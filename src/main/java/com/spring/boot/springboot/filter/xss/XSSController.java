package com.spring.boot.springboot.filter.xss;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class XSSController {


    @GetMapping(value = "/responseXss")
    @ResponseBody
    Map<String, Object> responseXss(){
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("htmlTdTag", "<td></td>");
        resultMap.put("htmlTableTag", "<table>");

        return resultMap;
    }

    @GetMapping(value = "/xssTest")
    public ModelAndView lucyTest(){
        ModelAndView mv = new ModelAndView("filter/xssTest");
        return mv;
    }

    @PostMapping(value = "/xssTest/ajax")
    public ModelAndView lucyTestAjax(XssRequestDTO xssRequest) {
        ModelAndView mv = new ModelAndView("filter/xssAjax");
        mv.addObject("result", xssRequest);
        return mv;
    }

    @PostMapping(value = "/xssTest/ajax/json")
    @ResponseBody
    public ResponseEntity<XssRequestDTO> lucyTestAjaxJson(@RequestBody XssRequestDTO xssRequest) {
        return new ResponseEntity<>(xssRequest, HttpStatus.OK);
    }
}
