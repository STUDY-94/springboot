package com.spring.boot.springboot.filter.xss.request;

import org.apache.commons.text.StringEscapeUtils;

public class XssUtils {
    public static String charEscape(String value) {
        return value == null ? value : StringEscapeUtils.escapeHtml4(value);
        //escapeHtml4 메서드는 HTML 태그를 치환해주는 역할
    }
}
