package cn.zsk.shardingconfigjavaconfig.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author:zsk
 * @CreateTime:2019-10-23 14:36
 */
@Data
@Accessors(chain = true)
public class UserEntity {

    private Integer id;

    private String name;

    private String sex;

    private Date createTime;

    private Date lastUpdateTime;
}
