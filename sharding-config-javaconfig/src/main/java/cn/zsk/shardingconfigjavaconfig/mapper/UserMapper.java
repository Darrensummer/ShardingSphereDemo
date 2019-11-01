package cn.zsk.shardingconfigjavaconfig.mapper;

import cn.zsk.shardingconfigjavaconfig.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:zsk
 * @CreateTime:2019-10-23 14:39
 */
@Mapper
public interface UserMapper {

    void inster(UserEntity userEntity);

}
