package com.spring.boot.springboot.jpa.dynamic.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "member")
@Data
@DynamicUpdate
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer age;
    private String delYn;
    private Integer crtBy;
    private Date crtDt;

    public Member() {}

    public Member(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
