package cn.zsk.shardingconfigjavaconfig.service.impl;


import cn.zsk.shardingconfigjavaconfig.entity.UserEntity;
import cn.zsk.shardingconfigjavaconfig.mapper.UserMapper;
import cn.zsk.shardingconfigjavaconfig.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zsk
 * @CreateTime:2019-10-23 14:37
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserEntity userEntity) {
        userMapper.inster(userEntity);
    }
}
