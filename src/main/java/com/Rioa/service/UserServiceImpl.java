package com.Rioa.service;

import com.Rioa.dao.UserRepository;
import com.Rioa.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, DigestUtils.md5DigestAsHex(password.getBytes()));
        return user;
    }

    @Override
    public User checkUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }
}
