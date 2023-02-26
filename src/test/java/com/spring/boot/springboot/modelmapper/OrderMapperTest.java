package com.spring.boot.springboot.modelmapper;

import com.spring.boot.springboot.modelmapper.model.Order;
import com.spring.boot.springboot.modelmapper.model.OrderDTO;
import com.spring.boot.springboot.modelmapper.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class OrderMapperTest {

    @Test
    @DisplayName("Order -> OrderDTO 매핑 테스트")
    public void _1() {
        //given
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order("태형", "유", "구리", "월스트릿");
        //when
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        //then
        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
    }

    @Test
    @DisplayName("같은 ProductVO 인데 몇몇의 변수는 null 값인 경우 매핑")
    public void _2() throws Exception{
        //given
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        Product sourceProduct = Product.builder()
                .prodSeq(0)
                .prodCd("100031")
                .price(3750)
                //delYn, crtBy, crtDt는 null
                .build();

        Product destinationProduct = Product.builder()
                .prodSeq(1)
                .prodCd("100031")
                .price(3600)
                .delYn("N")
                .crtBy(1)
                .crtDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-02-26 09:59:00"))
                .build();

        //when
        modelMapper.map(sourceProduct, destinationProduct);

        //then
        assertEquals(0, destinationProduct.getProdSeq());
        assertEquals("100031", destinationProduct.getProdCd());
        assertEquals(3750, destinationProduct.getPrice());
        assertEquals("N", destinationProduct.getDelYn());
    }
}
