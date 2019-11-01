package cn.zsk.shardingconfigyml.controller;

import cn.zsk.shardingconfigyml.entity.UserEntity;
import cn.zsk.shardingconfigyml.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author:zsk
 * @CreateTime:2019-10-31 14:37
 */
@RestController
@RequestMapping("/scy/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getList")
    public String getList(){
        List<UserEntity> userEntityList = userService.getList();
        List<UserEntity> userEntityListTemp = userEntityList.stream().sorted(Comparator.comparing(UserEntity :: getName)).collect(Collectors.toList());
        return JSONObject.toJSONString(userEntityListTemp);
    }

    @RequestMapping("addUser")
    public void addUser(){
        for(int i = 1 ; i <= 10 ; i++){
            //这里不用处理id,因为配置文件已经配置了主键生成策略，而且很长，不要用int类型。
            UserEntity userEntity = new UserEntity();
            userEntity.setName("zsk"+i);
            userEntity.setSex("男");
            Random random = new Random();
            // 生成一个0-99的数字，作为年龄
            int num = random.nextInt(100);
            userEntity.setAge(num);
            userService.addUser(userEntity);
        }

    }

    @RequestMapping("updateUser")
    public void updateUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("396970077838114816");
//        userEntity.setName("zskk1");
//        userEntity.setAge(20);

        try {
            userService.updateUserById(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
