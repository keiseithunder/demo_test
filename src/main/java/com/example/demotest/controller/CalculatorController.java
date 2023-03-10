package com.example.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
  
  @GetMapping("/add")
  public int add(){
    return 5;
  }
}
