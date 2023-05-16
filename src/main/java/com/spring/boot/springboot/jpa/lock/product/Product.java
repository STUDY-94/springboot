package com.spring.boot.springboot.jpa.lock.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int quantity;

    @Version
    private Integer version;

    public void decrease(int pickingCount) {
        validateStockCount(pickingCount);
        quantity -= pickingCount;
    }

    private void validateStockCount(int pickingCount) {
        if (pickingCount > quantity) {
            throw new IllegalArgumentException();
        }
    }
}
