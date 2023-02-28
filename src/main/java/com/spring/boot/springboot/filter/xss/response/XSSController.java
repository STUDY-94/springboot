package com.spring.boot.springboot.filter.xss.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
