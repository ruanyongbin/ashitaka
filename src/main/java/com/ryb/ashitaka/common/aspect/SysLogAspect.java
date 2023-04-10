package com.ryb.ashitaka.common.aspect;

import cn.hutool.json.JSONUtil;
import com.ryb.ashitaka.common.util.SecurityUtils;
import com.ryb.ashitaka.sys.entity.SysLog;
import com.ryb.ashitaka.sys.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class SysLogAspect {
	@Resource
	private SysLogService sysLogService;
	
	//定义切点 切点表达式指向SysLog注解，我们再业务方法上可以加上SysLog注解，然后所标注
	//的方法都能进行日志记录
	@Pointcut("@annotation(com.ryb.ashitaka.common.annotation.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long executionTime = System.currentTimeMillis() - beginTime;

		//保存日志
		saveSysLog(point, executionTime, result);

		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long executionTime, Object result) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLog sysLog = new SysLog();
		com.ryb.ashitaka.common.annotation.SysLog  sysLogAnnotation = method.getAnnotation(com.ryb.ashitaka.common.annotation.SysLog.class);
		if(sysLogAnnotation != null){
			//注解上的描述
			sysLog.setDescription(sysLogAnnotation.description());
			sysLog.setModule(sysLogAnnotation.module());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = Arrays.toString(args);
			sysLog.setParam(params);
		}catch (Exception e){
			log.error(e.getMessage(),e);
		}

		sysLog.setOperator(SecurityUtils.getCurrentUsername());

		sysLog.setResult(JSONUtil.toJsonStr(result));


//		//获取request
//		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//		//设置IP地址
//		sysLog.setIp(IPUtils.getIpAddr(request));

		sysLog.setExecutionTime(executionTime);
		//保存系统日志
		sysLogService.save(sysLog);
	}
}
