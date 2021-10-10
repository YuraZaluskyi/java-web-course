package com.bobocode.servlet;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.SneakyThrows;
public class MessageServletSocketClient {
  private final static String HOST = "172.17.96.1";
  private final static int PORT = 8080;
  @SneakyThrows
  public static void main(String[] args) {
    String message = "{\"name\":\"Donald\", \"message\":\"Hello!!!!!!!!!!!!!!!!\"}";
    Socket socket = new Socket(HOST, PORT);
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    writer.println("POST /message HTTP/1.1");
    writer.println("Host: localhost");
    writer.println("Content-Length: " + message.length());
    writer.println();
    writer.println(message);
    writer.flush();
  }
}
