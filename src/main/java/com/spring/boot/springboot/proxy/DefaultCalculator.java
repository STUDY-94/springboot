package com.spring.boot.springboot.proxy;

import java.lang.reflect.InvocationHandler;

public class DefaultCalculator implements Calculator {
    @Override
    public int calculate() {
        return 0; // 이 '0' 하나를 리턴하는데 무려 10초의 시간이 걸린다고 가정하자.
    }
}