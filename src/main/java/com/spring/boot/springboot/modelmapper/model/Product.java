package com.spring.boot.springboot.modelmapper.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private int prodSeq;
    private String prodCd;
    private Integer price;
    private String delYn;
    private Integer crtBy;
    private Date crtDt;

    @Builder
    public Product(int prodSeq, String prodCd, Integer price, String delYn, Integer crtBy, Date crtDt) {
        this.prodSeq = prodSeq;
        this.prodCd = prodCd;
        this.price = price;
        this.delYn = delYn;
        this.crtBy = crtBy;
        this.crtDt = crtDt;
    }
}
