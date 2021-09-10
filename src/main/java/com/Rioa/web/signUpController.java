package com.Rioa.web;

import com.Rioa.dao.SignupUserRepository;
import com.Rioa.po.SignupUser;
import com.Rioa.service.SignupUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "")
public class signUpController {
    @Autowired
    private SignupUserRepository signupUserRepository;
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public SignupUser addUser(@RequestParam(value = "studentId",required = true) String studentId,
                              @RequestParam(value = "studentName",required = true) String studentName,
                              @RequestParam(value = "hadLearn",defaultValue = "false",required = false) boolean hadLearn,
                              @RequestParam(value = "selfInfo",required = false) String selfIntro,
                              @RequestParam(value = "whyJoin",required = true) String whyJoin){
        SignupUser user = new SignupUser();
        user.setStudentId(studentId);
        user.setStudentName(studentName);
        user.setHadLearn(hadLearn);
        user.setSelfIntro(selfIntro);
        user.setWhyJoin(whyJoin);
        return signupUserRepository.save(user);
    }

}
