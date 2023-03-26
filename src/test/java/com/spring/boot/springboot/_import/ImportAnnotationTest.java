package com.spring.boot.springboot._import;

import com.spring.boot.springboot.spring_annotaion._import.ImportAnnotation;
import com.spring.boot.springboot.spring_annotaion._import.ImportConfig;
import com.spring.boot.springboot.spring_annotaion._import.config1;
import com.spring.boot.springboot.spring_annotaion._import.config2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@Import({ImportConfig.class})
//@SpringBootTest
public class ImportAnnotationTest {

    private final ImportAnnotation importAnnotation;

    public ImportAnnotationTest(@Autowired ImportAnnotation importAnnotation) {
        this.importAnnotation = importAnnotation;
    }

    @Test
    void _1() {
        importAnnotation.call();
    }
}
