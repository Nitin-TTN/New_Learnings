package com.redis.RedisApplication.service;

import com.redis.RedisApplication.entity.Employee;
import com.redis.RedisApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
   @Autowired
   private EmployeeRepository employeeRepository;
   public ResponseEntity<?> createEmployee(){
      Employee employee = new Employee(
       "Emp1001", "John Cena", Employee.Gender.MALE, 100000L);
      employeeRepository.save(employee);
      return ResponseEntity.ok().body("Employee created");
   }
   public ResponseEntity<?> createMultipleEmployees(){
      Employee employee1 = new Employee(
       "Emp1001", "John Cena", Employee.Gender.MALE, 100000L);
      Employee employee2 = new Employee(
       "Emp1002", "Chris Pine", Employee.Gender.MALE, 200000L);
      employeeRepository.save(employee1);
      employeeRepository.save(employee2);
      return ResponseEntity.ok().body("created");
   }


   public ResponseEntity<?> retrieveEmployee(){
      Employee employee =
       employeeRepository.findById("Emp1001").get();
      return  ResponseEntity.ok().body(employee);
   }

   public ResponseEntity<?> updateEmployee(){
      Employee employee =
       employeeRepository.findById("Emp1001").get();
      employee.setName("Nitin");
      employeeRepository.save(employee);
      return ResponseEntity.ok().body("updated"+ employee);
   }
}
