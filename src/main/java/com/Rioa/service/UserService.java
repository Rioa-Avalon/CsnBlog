package com.Rioa.service;

import com.Rioa.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
