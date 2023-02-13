package com.spring.boot.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorProxyHandler implements InvocationHandler {

    private final Calculator calculator;

    public CalculatorProxyHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("메서드 이름 : " + methodName);

        if (methodName.equals("calculate")) {
            System.out.println("믿을 수 없겠지만, 계산이 완료될 때까지 30초 남았습니다.");

            int calculationResult = calculator.calculate(); // DefaultCalculator에게 계산을 요청한다.

            System.out.println("계산이 완료되었습니다.");
            return calculationResult;
        } else {
            return null;
        }
    }
}
