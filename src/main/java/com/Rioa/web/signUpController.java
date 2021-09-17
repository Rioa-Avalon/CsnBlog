package com.Rioa.web;

import com.Rioa.dao.SignupUserRepository;
import com.Rioa.po.SignupUser;
import com.Rioa.service.SignupUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(description = "")
public class signUpController {
    @Autowired
    private SignupUserService signupUserService;

    //it only can be invoked by the specific Origin
    //@CrossOrigin(origins = "https://csd.guet.ltd")
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public SignupUser addUser(@RequestParam(value = "studentId",required = true) String studentId,
                              @RequestParam(value = "studentName",required = true) String studentName,
                              @RequestParam(value = "hadLearn",defaultValue = "false",required = false) boolean hadLearn,
                              @RequestParam(value = "selfIntro",required = false) String selfIntro,
                              @RequestParam(value = "whyJoin",required = true) String whyJoin,
                              @RequestParam(value = "email",required = true) String email,
                              @RequestParam(value = "qq",required = true) String qq){
        SignupUser user = new SignupUser();
//        if(signupUserService.findUser(request.getParameter("studentId"),
//                                      request.getParameter("studentName")) {
//            return "user already exist";
//        }
        user.setStudentId(studentId);
        user.setStudentName(studentName);
        user.setHadLearn(hadLearn);
        user.setEmail(email);
        user.setQq(qq);
        //only when user already had learned before add selfIntro
        if (user.isHadLearn()) {
            user.setSelfIntro(selfIntro);
        }
        user.setWhyJoin(whyJoin);
//        if (user.getStudentId() == signupUserService.)
        return signupUserService.saveUser(user);
    }

}
