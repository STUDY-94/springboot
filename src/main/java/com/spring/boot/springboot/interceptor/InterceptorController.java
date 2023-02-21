package com.spring.boot.springboot.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorController {

    @GetMapping("/interceptor")
    public ModelAndView interceptor() {
        ModelAndView mv = new ModelAndView("/interceptor/interceptor");
        mv.addObject("uri", "/interceptor");
        System.out.println("Controller 호출 (uri : /interceptor)");
        return mv;
    }

    @GetMapping("/noInterceptor")
    public ModelAndView noInterceptor() {
        ModelAndView mv = new ModelAndView("/interceptor/interceptor");
        mv.addObject("uri", "/noInterceptor");
        System.out.println("Controller 호출 (uri : /noInterceptor)");
        return mv;
    }


}
