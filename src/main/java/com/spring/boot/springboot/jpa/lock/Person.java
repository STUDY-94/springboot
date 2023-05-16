package com.spring.boot.springboot.jpa.lock;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;

    @Version
    private int age;

}
