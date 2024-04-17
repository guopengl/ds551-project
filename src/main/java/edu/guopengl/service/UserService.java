package edu.guopengl.service;

import edu.guopengl.entity.User;
import edu.guopengl.mapper.UserMapper;
import edu.guopengl.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByNameAndPassword(LoginParams request){
        return userMapper.findByNameAndPassword(request.getUsername(), request.getPassword());
    }

}
