package com.spring.boot.springboot.jpa.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LockService {

    @Autowired
    LockRepository lockRepository;

    @Transactional(readOnly = true)
    public Person findById(Long id) {
        Optional<Person> byId = lockRepository.findById(id);
        return byId.get();
    }

    @Transactional
    public Person updateAge(int age) {
        Person byId = lockRepository.findById(1L).get();
        byId.setAge(age);
        return lockRepository.save(byId);
    }

}
