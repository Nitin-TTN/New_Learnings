package com.microservice.Product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CouponDto {
   private Long id;
   private String code;
   private BigDecimal discount;
   private String expDate;
}

