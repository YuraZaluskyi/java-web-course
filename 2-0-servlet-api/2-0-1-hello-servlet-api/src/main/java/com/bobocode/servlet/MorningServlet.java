package com.bobocode.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import javax.swing.text.html.Option;
import lombok.SneakyThrows;

@WebServlet("/morning")
public class MorningServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    printClientMood(req);
    printClientCookies(req);
    printMorning(req, resp);
    resp.addCookie(new Cookie("SUPER-ID", UUID.randomUUID().toString()));
  }

  private void printClientCookies(HttpServletRequest req) {

    Stream.of(req.getCookies())
        .forEach(c -> System.out.println(c.getName() + " " + c.getValue()));
  }


  @SneakyThrows
  private void printMorning(HttpServletRequest req, HttpServletResponse resp) {
    HttpSession session = req.getSession();
    Optional<String> sessionName = Optional.ofNullable((String) session.getAttribute("name"));
    Optional<String> requestName = Optional.ofNullable(req.getParameter("name"));
    requestName.filter(name -> sessionName.isEmpty())
        .ifPresent(name -> session.setAttribute("name", name));

    PrintWriter writer = resp.getWriter();
    String name = requestName
        .or(() -> sessionName)
        .orElse("my friend");
    writer.println("Good morning, " + name);
  }

  private void printClientMood(HttpServletRequest req) {
    String name = Optional.ofNullable(req.getParameter("name"))
        .orElse(req.getRemoteAddr());
    Optional.ofNullable(req.getHeader("X-Mood"))
        .ifPresent(mood -> System.out.println(name + " is feeling " + mood));
  }
}
