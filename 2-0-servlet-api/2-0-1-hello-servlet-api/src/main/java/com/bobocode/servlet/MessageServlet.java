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

  private List<Message> messageList = Collections.synchronizedList(new ArrayList<>());
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    messageList.forEach(
        m -> writer.printf("<h1> - %s [%s]</h1>", m.getMessage(), m.getName())
    );
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Message message = readMessageFrom(req);
    messageList.add(message);
  }

  @SneakyThrows
  private Message readMessageFrom(HttpServletRequest req) {
    BufferedReader reader = req.getReader();
    String jsonStr = reader.lines().collect(Collectors.joining());
    return objectMapper.readValue(jsonStr, Message.class);
  }
}
