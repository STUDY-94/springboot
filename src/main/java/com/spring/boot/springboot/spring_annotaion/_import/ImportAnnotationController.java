package com.spring.boot.springboot.spring_annotaion._import;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImportAnnotationController {

    @Autowired
    @Qualifier("realIA")
//    private ImportAnnotation importAnnotation;
    private ImportAnnotation importAnnotation2;

    @RequestMapping(value = "/ia")
    @ResponseBody
    public String render() {
//        importAnnotation.call();
        importAnnotation2.call();
        return "@Import";
    }
}
