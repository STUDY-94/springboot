package com.spring.boot.springboot.proxy;

public class DefaultCalculatorProxy implements Calculator {

    //새롭게 할당하지 않을 경우
//    private final Calculator calculator;

    //지연 초기화
    private Calculator calculator;

    public DefaultCalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calculate() {
        // 지연 초기화(lazy initialization)
        if (calculator == null) {
            calculator = new DefaultCalculator();
        }

        System.out.println("믿을 수 없겠지만, 계산이 완료될 때까지 10초 남았습니다.");

        int calculationResult = calculator.calculate(); // DefaultCalculator에게 계산을 요청한다.

        System.out.println("계산이 완료되었습니다.");
        return calculationResult;
    }
}