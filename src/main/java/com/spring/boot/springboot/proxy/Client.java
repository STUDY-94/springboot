package com.spring.boot.springboot.proxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        /*
        //Cacluator

        //대상 객체의 메서드 직접 호출
//        Calculator calculator2 = new DefaultCalculator();
//        calculator2.calculate();

        //직접 구현한 프록시 패턴
//        Calculator calculator = new DefaultCalculatorProxy(new DefaultCalculator());
//        calculator.calculate();

        //자바에서 제공하는 프록시
        Calculator calculator = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[] { Calculator.class },
                new CalculatorProxyHandler(new DefaultCalculator())
        );
        calculator.calculate();
        */


//        //Image
//        Image image1 = new Proxy_Image("test1.png");
//        Image image2 = new Proxy_Image("test2.png");
//
//        image1.displayImage();
//        System.out.println();
//        image2.displayImage();

        //Image
        Image image1 = ProxyImageSingleton.getInstance();
        Image image2 = ProxyImageSingleton.getInstance();

        image1.displayImage();
        System.out.println();
        image2.displayImage();
    }
}
