package com.microservice.Product.controller;

import com.microservice.Product.dto.CouponDto;
import com.microservice.Product.entity.Product;
import com.microservice.Product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

   @Autowired
   ProductRepo productRepo;

   @Autowired
   RestTemplate restTemplate;

   @Value("${couponService.url}")
   private String couponServiceUrl;

   @PostMapping("/create")
   public Product create(@RequestBody Product product){
      CouponDto coupon = restTemplate.getForObject(couponServiceUrl+product.getCouponCode(), CouponDto.class);
      product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
      return productRepo.save(product);
   }

   @GetMapping("/get/{id}")
   public Optional<Product> getProduct(@PathVariable Long id){
      return productRepo.findById(id);
   }
}