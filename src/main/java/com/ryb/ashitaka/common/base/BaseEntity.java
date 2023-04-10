package com.ryb.ashitaka.common.base;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 2710681381483343076L;
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;
    @Version
    private Integer version;
    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;

}
