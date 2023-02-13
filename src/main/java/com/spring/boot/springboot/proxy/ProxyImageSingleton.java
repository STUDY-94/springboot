package com.spring.boot.springboot.proxy;

import lombok.Data;

@Data
public class ProxyImageSingleton implements Image {
    private String fileName;
    private static ProxyImageSingleton instance;

    public static ProxyImageSingleton getInstance() {
        if (instance == null) {
            instance = new ProxyImageSingleton();
        }
        return instance;
    }

    //싱글톤 생성자는 반드시 private
    private ProxyImageSingleton() {}

    private ProxyImageSingleton(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying " + fileName);
    }
}
