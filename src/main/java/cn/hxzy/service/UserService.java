package cn.hxzy.service;


import cn.hxzy.mapper.UserMapper;
import cn.hxzy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;
    public User queryUserById(Long userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    @Transactional
    public void deleteUserById(Long userId){
        userMapper.deleteByPrimaryKey(userId);
    }

    public List<User> queryAll() {
        return userMapper.selectAll();
    }
}
