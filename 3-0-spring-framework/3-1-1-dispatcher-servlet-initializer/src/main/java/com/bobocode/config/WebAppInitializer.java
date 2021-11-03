package com.bobocode.config;

import com.bobocode.util.ExerciseNotCompletedException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class is used to configure DispatcherServlet and links it with application config classes
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
//        throw new ExerciseNotCompletedException(); //todo: use {@link RootConfig} as root application config class
    return new Class[]{RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
//        throw new ExerciseNotCompletedException(); //todo: use {@link WebConfig} as ServletConfig class
    return new Class[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
//        throw new ExerciseNotCompletedException(); //todo: provide default servlet mapping ("/")
    return new String[]{"/"};
  }
}
