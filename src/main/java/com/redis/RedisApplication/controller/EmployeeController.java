package com.redis.RedisApplication.controller;

import com.redis.RedisApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class EmployeeController {
   @Autowired
   private EmployeeService employeeService;

   @PostMapping("/create")
   public ResponseEntity<?> createEmployee() {
      return employeeService.createEmployee();
   }

   @PostMapping("/create/multiple")
   public ResponseEntity<?> createMultiple() {
      return employeeService.createMultipleEmployees();
   }

   @PatchMapping("/update")
   public ResponseEntity<?> updateEmployee() {
      return employeeService.updateEmployee();
   }

   @GetMapping("/retrieve")
   public ResponseEntity<?> retrieveEmployee() {
      return employeeService.retrieveEmployee();
   }

}
