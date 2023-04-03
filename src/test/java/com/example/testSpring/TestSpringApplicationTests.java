package com.example.testSpring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestSpringApplicationTests {


  public static void main(String[] args) {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String format = LocalDateTime.now().plusDays(1).format(dateTimeFormatter);
     System.out.println(format);
    LocalDateTime localDateTime;
    localDateTime=   LocalDateTime.parse("2023-03-18 11:38:24",dateTimeFormatter);
    System.out.println(dateTimeFormatter.format(localDateTime));
    Instant instant =  Instant.now();
    System.out.println(instant);
    System.out.println(dateTimeFormatter.format(instant));
     ObjectMapper objectMapper = new ObjectMapper();
  }

  static int tableSizeFor(int cap) {
    int n = cap - 1;
    System.out.println("n:" + n);
    n |= n >>> 1;
    System.out.println("n|= n >>> 1:  " + n);
    n |= n >>> 2;
    System.out.println("n|= n >>> 2:  " + n);
    n |= n >>> 4;
    System.out.println("n|= n >>> 4:  " + n);
    n |= n >>> 8;
    System.out.println("n|= n >>> 8:  " + n);
    n |= n >>> 16;
    System.out.println("n|= n >>> 16: " + n);
    return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
  }
}

class Fruit {}

class Apple extends Fruit {}
