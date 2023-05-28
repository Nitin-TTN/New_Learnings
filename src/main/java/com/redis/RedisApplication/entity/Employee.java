package com.redis.RedisApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
   private String id;
   private String name;

   public enum Gender {
      MALE, FEMALE
   }

   private Gender gender;
   private long salary;
}
