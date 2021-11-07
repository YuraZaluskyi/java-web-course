package com.bobocode;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import lombok.SneakyThrows;

public class Client {

  @SneakyThrows
  public static void main(String[] args) {
    try (Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8899)) {
      BufferedWriter writer = new BufferedWriter(
          new OutputStreamWriter(socket.getOutputStream()));
      writer.write("Hello! \n");
      writer.flush();
    }
  }
}
