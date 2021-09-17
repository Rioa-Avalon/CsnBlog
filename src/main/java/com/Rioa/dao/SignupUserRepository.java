package com.Rioa.dao;

import com.Rioa.po.SignupUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupUserRepository extends JpaRepository<SignupUser,Long> {
    SignupUser findSignupUsersByStudentIdAndStudentName(String studentId, String studentName);
}
