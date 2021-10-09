package com.bobocode.servlet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.SneakyThrows;

public class Main {

  @SneakyThrows
  public static void main(String[] args) {
    int PORT = 8080; // you can use any free port you want
    Socket clientSocket = new Socket("172.17.96.1", PORT);


    PrintWriter printWriter = new PrintWriter(
        new OutputStreamWriter(clientSocket.getOutputStream()));
    printWriter.println("GET /morning HTTP/1.1");
//    printWriter.println("GET /morning HTTP/1.1");
    printWriter.println("Host: 172.17.96.1");
    printWriter.println("X-Mood: I feel good!!!!!!!!!!!!!)");
    printWriter.println("Cookie: JSESSIONID=FC8520ABE8EEFEC5FBDFE15454A9F199");
    printWriter.println();
    printWriter.flush();
    InputStream inputStream = clientSocket.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    bufferedReader.lines().forEach(System.out::println);
  }
}
