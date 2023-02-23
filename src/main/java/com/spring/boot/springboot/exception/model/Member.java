package com.spring.boot.springboot.exception.model;

import com.spring.boot.springboot.exception.validator.IdUnique;
import com.spring.boot.springboot.exception.validator.LengthCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Member {

    @NotEmpty
//    @javax.validation.constraints.Email
    @IdUnique
    private String id;
    private String name;
    @LengthCheck
    private String nickname;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member(String id, String name, String nickname) {
        this(id, name);
        this.nickname = nickname;
    }
}
