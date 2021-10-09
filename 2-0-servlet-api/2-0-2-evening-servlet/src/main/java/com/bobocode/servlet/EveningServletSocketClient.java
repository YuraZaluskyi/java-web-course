package com.bobocode.servlet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.SneakyThrows;
public class EveningServletSocketClient {
  private final static String HOST = "172.17.96.1";
  private final static int PORT = 8080;
  @SneakyThrows
  public static void main(String[] args) {
    Socket socket = new Socket(HOST, PORT);
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    writer.println("GET /evening HTTP/1.1");
    writer.println("Host: " + HOST);
    writer.println("Cookie: JSESSIONID=B2ED3DEB2C52428604BDDA51C2230FF3");
    writer.println();
    writer.flush();
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    reader.lines().forEach(System.out::println);
  }
}