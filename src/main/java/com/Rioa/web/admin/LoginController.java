package com.Rioa.web.admin;

import com.Rioa.dao.UserRepository;
import com.Rioa.po.User;
import com.Rioa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

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
                user.setPassword(password);
                userRepository.save(user);
                return "redirect:/admin/login";
            }
        }
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        System.out.println(user);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/blogs";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
