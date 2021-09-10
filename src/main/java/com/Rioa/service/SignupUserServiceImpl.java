package com.Rioa.service;

import com.Rioa.NotFoundException;
import com.Rioa.dao.SignupUserRepository;
import com.Rioa.po.SignupUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class SignupUserServiceImpl implements SignupUserService {
    @Autowired
    private SignupUserRepository signupUserRepository;

    @Transactional
    @Override
    public SignupUser saveUser(SignupUser signupUser) {
        return signupUserRepository.save(signupUser);
    }

    @Transactional
    @Override
    public SignupUser updataUser(Long id, SignupUser signupUser) {
        SignupUser user = signupUserRepository.getById(id);
        if (user == null) {
            throw new NotFoundException("The user not exist");
        }
        //
        return signupUserRepository.save(signupUser);
    }

    @Transactional
    @Override
    public SignupUser getUser(Long id) {
        return signupUserRepository.getById(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        signupUserRepository.deleteById(id);
    }
}
