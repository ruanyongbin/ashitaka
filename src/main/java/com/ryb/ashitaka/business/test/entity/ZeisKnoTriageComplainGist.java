package com.ryb.ashitaka.business.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 分诊主诉依据
 * </p>
 *
 * @author ryb
 * @since 2023-05-04
 */
@Getter
@Setter
@TableName("ZEIS_KNO_TRIAGE_COMPLAIN_GIST")
@ApiModel(value = "ZeisKnoTriageComplainGist对象", description = "分诊主诉依据")
public class ZeisKnoTriageComplainGist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @ApiModelProperty("分诊主诉ID")
    @TableField("TRIAGE_COMPLAIN_ID")
    private String triageComplainId;

    @ApiModelProperty("依据名称")
    @TableField("TRIAGE_COMPLAIN_GIST_NAME")
    private String triageComplainGistName;

    @ApiModelProperty("分诊等级")
    @TableField("TRIAGE_LEVEL_CODE")
    private String triageLevelCode;

    @ApiModelProperty("分诊去向")
    @TableField("TRIAGE_DIRECTION_CODE")
    private String triageDirectionCode;

    @ApiModelProperty("一键分诊标识：1 启用 0 未启用")
    @TableField("ONE_KEY_TRIAGE_FLAG")
    private BigDecimal oneKeyTriageFlag;

    @ApiModelProperty("一键分诊名称")
    @TableField("ONE_KEY_TRIAGE_NAME")
    private String oneKeyTriageName;

    @ApiModelProperty("拼音码")
    @TableField("SPELL_CODE")
    private String spellCode;

    @ApiModelProperty("排序号")
    @TableField("SORT_NO")
    private BigDecimal sortNo;

    @ApiModelProperty("有效标志 0 无效 1有效")
    @TableField("VALID_FLAG")
    private Integer validFlag;

    @ApiModelProperty("创建人编码")
    @TableField("CREATOR_CODE")
    private String creatorCode;

    @ApiModelProperty("创建时间")
    @TableField("CREATED_TIME")
    private LocalDateTime createdTime;

    @ApiModelProperty("修改人编码")
    @TableField("MODIFIER_CODE")
    private String modifierCode;

    @ApiModelProperty("修改时间")
    @TableField("MODIFIED_TIME")
    private LocalDateTime modifiedTime;

    @ApiModelProperty("默认分诊科室编码")
    @TableField("TRIAGE_DEPT_CODE")
    private String triageDeptCode;

    @ApiModelProperty("片区编码")
    @TableField("WARD_CODE")
    private String wardCode;


}
