package com.example.demotest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demotest.controller.CalculatorController;

@SpringBootTest
class DemotestApplicationTests {

  @Autowired
  private CalculatorController calculatorController;

  @Test
  void contextLoads() {
    assertThat(calculatorController).isNotNull();
  }

}
