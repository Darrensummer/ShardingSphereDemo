package cn.zsk.shardingconfigyml.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author:zsk
 * @CreateTime:2019-10-31 14:30
 */
@TableName("t_user0")
@Data
@Accessors(chain = true)
public class UserEntity {

    private String id;

    private String name;

    private String sex;

    private Integer age;

    @TableField("is_deleted")
    @TableLogic
    private int deleteFlag;

    private Date createTime;

    private Date lastUpdateTime;
}
