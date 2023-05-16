package com.spring.boot.springboot.jpa.lock;

import com.spring.boot.springboot.jpa.lock.product.Product;
import com.spring.boot.springboot.jpa.lock.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OptimisticLockTest {

    @Autowired
    ProductService productService;

    @Test
    void _1() {
        Product product = new Product();
        product.setQuantity(3);
        productService.save(product);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<?> future = executorService.submit(
                () -> productService.decrease(product.getId(), 1));
        Future<?> future2 = executorService.submit(
                () -> productService.decrease(product.getId(), 1));
        Future<?> future3 = executorService.submit(
                () -> productService.decrease(product.getId(), 1));

        Exception result = new Exception();

        try {
            future.get();
            future2.get();
            future3.get();
        } catch (ExecutionException e) {
            result = (Exception) e.getCause();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertTrue(result instanceof OptimisticLockingFailureException);
    }
}
