package cn.zsk.shardingconfigyml.service.impl;

import cn.zsk.shardingconfigyml.entity.UserEntity;
import cn.zsk.shardingconfigyml.mapper.UserMapper;
import cn.zsk.shardingconfigyml.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2019-10-31 14:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getList() {
        return userMapper.selectList(new QueryWrapper<UserEntity>()
                .eq("is_deleted",0));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserEntity userEntity) {
        userEntity.setCreateTime(new Date())
                .setDeleteFlag(0);
        userMapper.insert(userEntity);
    }

    @Override
    public void updateUserById(UserEntity userEntity) throws Exception {
        if(null == userEntity.getId()){
            throw new Exception("更新用户信息，id为空");
        }
        userEntity.setLastUpdateTime(new Date());
        userMapper.update(null,new UpdateWrapper<UserEntity>()
                .set(null != userEntity.getName(),"name",userEntity.getName())
                .set(null != userEntity.getAge(),"age",userEntity.getAge())
                .set(null != userEntity.getSex(),"sex",userEntity.getSex())
                .set("last_update_time",new Date())
                .eq("id",userEntity.getId()));
    }


}
