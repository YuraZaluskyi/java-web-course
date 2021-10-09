package com.bobocode.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/evening")
public class EveningServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    Optional<String> sessionName = Optional.ofNullable((String) session.getAttribute("name"));
    Optional<String> requestName = Optional.ofNullable(req.getParameter("name"));

    requestName.filter(name -> sessionName.isEmpty())
        .ifPresent(name -> session.setAttribute("name", name));
    String name = requestName.or(() -> sessionName).orElse("everybody");

    PrintWriter writer = resp.getWriter();
    writer.println("Good evening, " + name);
  }
}
