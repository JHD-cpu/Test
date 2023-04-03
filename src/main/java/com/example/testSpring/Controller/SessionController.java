package com.example.testSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/put")
    public String putsession(@RequestParam String name, @RequestParam String value) {
        httpSession.setAttribute(name,value);

      return  "SUCCESS";
    }
    @RequestMapping("/get")
    public Object getsession(@RequestParam String name ) {
        return   httpSession.getAttribute(name);
    }
}
