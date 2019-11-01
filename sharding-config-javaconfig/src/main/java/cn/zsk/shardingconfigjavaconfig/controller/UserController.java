package cn.zsk.shardingconfigjavaconfig.controller;

import cn.zsk.shardingconfigjavaconfig.entity.UserEntity;
import cn.zsk.shardingconfigjavaconfig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author:zsk
 * @CreateTime:2019-10-23 16:47
 */
@RestController
@RequestMapping("sj/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    public void addUser(){

        UserEntity userEntity = new UserEntity();
        userEntity.setCreateTime(new Date())
                .setName("zsk")
                .setSex("男");

        userService.addUser(userEntity);
    }
}
