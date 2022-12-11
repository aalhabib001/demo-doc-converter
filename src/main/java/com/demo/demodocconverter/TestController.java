package com.demo.demodocconverter;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {
  private final DocConverter docConverter;

  @GetMapping("/convert")
  public String convert() {
    return "Hello World";
  }
}
