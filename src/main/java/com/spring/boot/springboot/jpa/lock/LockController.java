package com.spring.boot.springboot.jpa.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
public class LockController {

    @Autowired
    LockService lockService;

    @GetMapping(value = "/wannagohome/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") Long id){
        return lockService.findById(id).toString();
    }

    @GetMapping(value = "/updateandwannagohome/{age}")
    @ResponseBody
    public String findById(@PathVariable("age") Integer age){
        lockService.updateAge(age);
        return "wanna go home!";
    }
}
