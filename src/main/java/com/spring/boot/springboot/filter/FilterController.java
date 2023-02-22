package com.spring.boot.springboot.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilterController {

    @GetMapping("/filter")
    public ModelAndView filter() {
        ModelAndView mv = new ModelAndView("/filter/filter");
        mv.addObject("uri" , "/filter");
        System.out.println("Controller 호출 (uri : /filter)");
        return mv;
    }

    @GetMapping("/filter/test")
    public ModelAndView filterTest() {
        ModelAndView mv = new ModelAndView("/filter/filter");
        mv.addObject("uri" , "/filter/test");
        System.out.println("Controller 호출 (uri : /filter/test)");
        return mv;
    }

    @GetMapping("/filter2")
    public ModelAndView filter2() {
        ModelAndView mv = new ModelAndView("/filter/filter");
        mv.addObject("uri" , "/filter2");
        System.out.println("Controller 호출 (uri : /filter2)");
        return mv;
    }

    @GetMapping("/filter2/test")
    public ModelAndView filter2Test() {
        ModelAndView mv = new ModelAndView("/filter/filter");
        mv.addObject("uri" , "/filter2/test");
        System.out.println("Controller 호출 (uri : /filter2/test)");
        return mv;
    }

    @GetMapping("/filter3")
    public ModelAndView filter3() {
        ModelAndView mv = new ModelAndView("/filter/filter");
        mv.addObject("uri" , "/filter3");
        System.out.println("Controller 호출 (uri : /filter3)");
        return mv;
    }

    @GetMapping("/filter3/test")
    public ModelAndView filter3Test() {
        ModelAndView mv = new ModelAndView("/filter/filter");
        mv.addObject("uri" , "/filter3/test");
        System.out.println("Controller 호출 (uri : /filter3/test)");
        return mv;
    }
}
