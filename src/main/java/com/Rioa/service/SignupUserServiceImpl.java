package com.Rioa.service;

import com.Rioa.NotFoundException;
import com.Rioa.dao.SignUser2Repository;
import com.Rioa.dao.SignupUserRepository;
import com.Rioa.po.SignUser2;
import com.Rioa.po.SignupUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupUserServiceImpl implements SignupUserService {
    @Autowired
    private SignupUserRepository signupUserRepository;

    @Autowired
    private SignUser2Repository signUser2Repository;

    @Override
    public SignUser2 saveUser2(SignUser2 signUser2) {
        return signUser2Repository.save(signUser2);
    }

    @Override
    public SignupUser findUser(String studentId, String studentName) {
        return signupUserRepository.findSignupUsersByStudentIdAndStudentName(studentId,studentName);
    }

    @Override
    public SignupUser saveUser(SignupUser signupUser) {
        return signupUserRepository.save(signupUser);
    }

    @Override
    public SignupUser updataUser(Long id, SignupUser signupUser) {
        SignupUser user = signupUserRepository.getById(id);
        if (user == null) {
            throw new NotFoundException("The user not exist");
        }
        //
        return signupUserRepository.save(signupUser);
    }

    @Override
    public SignupUser getUser(Long id) {
        return signupUserRepository.getById(id);
    }

    @Override
    public void deleteUser(Long id) {
        signupUserRepository.deleteById(id);
    }
}
