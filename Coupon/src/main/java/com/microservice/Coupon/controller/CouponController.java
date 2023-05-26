package com.microservice.Coupon.controller;

import com.microservice.Coupon.repository.CouponRepo;
import com.microservice.Coupon.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {

   @Autowired
   CouponRepo couponRepo;

   @PostMapping("/coupons")
   public Coupon create(@RequestBody Coupon coupon) {
      return couponRepo.save(coupon);
   }

   @GetMapping("/coupons/{code}")
   public Coupon getCoupon(@PathVariable String code) {
      return couponRepo.findByCode(code);
   }
}
