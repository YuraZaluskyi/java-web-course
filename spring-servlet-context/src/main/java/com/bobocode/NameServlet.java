package com.bobocode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/name")
public class NameServlet extends HttpServlet {

  private static final String STRING_APP_CONTEXT = "STRING_APP_CONTEXT";

  @Override
  public void init(ServletConfig config) throws ServletException {
    AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
        WebConfig.class);
    ServletContext servletContext = config.getServletContext();
    servletContext.setAttribute(STRING_APP_CONTEXT, springContext);

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    AnnotationConfigApplicationContext springContext = (AnnotationConfigApplicationContext) req.getServletContext()
        .getAttribute(STRING_APP_CONTEXT);
    NameProvider nameProvider = springContext.getBean(NameProvider.class);
    PrintWriter writer = resp.getWriter();
    writer.println(nameProvider.getName());
    writer.flush();
  }
}
