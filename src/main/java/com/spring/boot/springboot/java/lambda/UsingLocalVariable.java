package com.spring.boot.springboot.java.lambda;

public class UsingLocalVariable {
    void method(int arg) {
        int localVar = 40;

        //수정시 fianl 변수가 아니게 되므로 lambda식에서 사용 불가
//        arg = 31;
//        localVar = 41;

        FunctionalInterface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar : " + localVar + "\n");
        };
        fi.method();
    }
}
