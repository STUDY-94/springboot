package com.spring.boot.springboot.java.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> intList = new ArrayList<>();

        // 테스트할 loop의 개수...
        for (int i = 0; i<1000000; i++) {
            intList.add(i);
        }

        // normal for loop
        long startTime = System.currentTimeMillis();
        for (Integer integer : intList) {
            if(integer % 1000 == 0) {
                //System.out.println(integer);
                //Thread.sleep(10);
            }
        }
        long endTime = System.currentTimeMillis();

        // stream foreach
        long startTime2 = System.currentTimeMillis();
        intList.stream().forEach(integer -> {
            if(integer % 1000 == 0) {
//                System.out.println(integer);
                try {
//                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        long endTime2 = System.currentTimeMillis();

        // parallelStream foreach
        long startTime3 = System.currentTimeMillis();
        intList.parallelStream().forEach(integer -> {
            if(integer % 1000 == 0) {
//                System.out.println(integer);
                try {
//                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        long endTime3 = System.currentTimeMillis();

        System.out.println("##  1 소요시간(초.0f) : " + ( endTime - startTime )/1000.000f +"초");
        System.out.println("##  2 소요시간(초.0f) : " + ( endTime2 - startTime2 )/1000.000f +"초");
        System.out.println("##  3 소요시간(초.0f) : " + ( endTime3 - startTime3 )/1000.000f +"초");
    }
}
