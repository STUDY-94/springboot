package com.spring.boot.springboot.jpa.lock.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void decrease(Long productId, int cnt) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalStateException::new);

        product.decrease(cnt);
        productRepository.save(product);
    }
}