package com.spring.boot.springboot.spring_annotaion._import;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ImportAnnotation {

    private final Bean1 bean1;
    private final Bean2 bean2;

    @Autowired
    public ImportAnnotation(Bean1 bean1, Bean2 bean2) {
        this.bean1 = bean1;
        this.bean2 = bean2;
    }

    public void call() {
        bean1.call();
        bean2.call();
    }
}
