package com.bobocode.servlet;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.SneakyThrows;

public class EveningServletHttpClient {

  @SneakyThrows
  public static void main(String[] args) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8080/evening?name=Yura")).build();
    HttpResponse<String>  response = httpClient.send(request, BodyHandlers.ofString());
    System.out.println(response.body());
  }
}
