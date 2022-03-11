package com.example.jenkins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jenkins")
public class JenkinsRestController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserBean userBean;

    @Value("${jenkins.message}")
    private String message;

    @GetMapping("/test")
    public String getJenkinsMessage(){
        logger.info("Inside jenkins api");
        return message;
    }

    @GetMapping("/user")
    public User getUserMessage(){
        User user=new User();
        user.setName(userBean.getName());
        user.setEmail(userBean.getEmail());
        logger.info("Inside user api");
        return user;
    }
}
