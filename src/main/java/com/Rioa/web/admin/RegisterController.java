package com.Rioa.web.admin;

import com.Rioa.dao.UserRepository;
import com.Rioa.po.User;
import com.Rioa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public String register(HttpServletRequest request,
                           RedirectAttributes attributes) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(password.equals(confirmPassword)) {
            if(userService.checkUser(username,password) != null) {
                attributes.addFlashAttribute("message", "该用户名已经存在");
                return "redirect:/admin/login";
            }else {
                //add
                User user = new User();
                user.setUsername(username);
                user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
                userRepository.save(user);
                attributes.addFlashAttribute("message", "User create succeed");
                return "redirect:/admin/login";
            }
        }
        return "admin/login";
    }

}
