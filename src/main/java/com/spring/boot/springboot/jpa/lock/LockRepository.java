package com.spring.boot.springboot.jpa.lock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockRepository extends JpaRepository<Person, Long> {



}
