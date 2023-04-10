package com.ryb.ashitaka.business.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryb.ashitaka.business.test.entity.TestStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ryb
 * @since 2023-04-10
 */
@Mapper
public interface TestStudentMapper extends BaseMapper<TestStudent> {

}
