package com.Rioa.service;

import com.Rioa.po.SignupUser;

public interface SignupUserService {
    SignupUser findUser(String studentId, String studentName);
    SignupUser saveUser(SignupUser sigupUser);
    SignupUser getUser(Long id);
    SignupUser updataUser(Long id, SignupUser sigupUser);
    void deleteUser(Long id);
}
