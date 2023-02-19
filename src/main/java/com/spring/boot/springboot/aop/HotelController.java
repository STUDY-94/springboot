package com.spring.boot.springboot.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @GetMapping("/in")
    @ResponseBody
    public String checkIn() {
        return "check-in";
    }

    @GetMapping("/out")
    @ResponseBody
    public String checkOut() {
        return "check-out";
    }

    @GetMapping("/inout")
    @ResponseBody
    public int inOut() {
        return 1;
    }

    @GetMapping("/outin")
    @ResponseBody
    public boolean outIn() {
        return true;
    }

}
