package com.bobocode.service;

import com.bobocode.annotation.Trimmed;
import org.springframework.stereotype.Service;

@Service
@Trimmed
public class HelloService {

  public String greeting(String str1, String str2, Integer number) {
    System.out.println(str1);
    System.out.println(str2);
    return "      acwcaawadafdawfawfawfwfzxcvb     ";
  }
}
