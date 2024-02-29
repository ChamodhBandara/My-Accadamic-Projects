package com.fullstack.employee.leave.management.system.controler;


import com.fullstack.employee.leave.management.system.MYUserModel.UserModel;
import com.fullstack.employee.leave.management.system.UserModel.User;
import com.fullstack.employee.leave.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody UserModel userModel){
       User newUser=new User();
       newUser.setEmail(userModel.getEmail());
       newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
       return userRepository.save(newUser);
    }
    @GetMapping("/dashboad")
    public String dashboad(){
        return "Your Seeing the dashboad content";
    }
}
