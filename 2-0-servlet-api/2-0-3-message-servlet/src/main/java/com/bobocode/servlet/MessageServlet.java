package com.bobocode.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

  private Message message = new Message();
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintWriter writer = resp.getWriter();

    writer.println("NAME - " + message.getName() + " ----- " + "MESSAGE - " + message.getMessage());
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Message message = readMessageFrom(req);
    this.message = message;
  }

  @SneakyThrows
  private Message readMessageFrom(HttpServletRequest req) {
    BufferedReader reader = req.getReader();
    String jsonStr = reader.lines().collect(Collectors.joining());
    Message message = objectMapper.readValue(jsonStr, Message.class);
    return message;
  }
}
