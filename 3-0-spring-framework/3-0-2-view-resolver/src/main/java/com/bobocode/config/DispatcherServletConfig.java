package com.bobocode.config;

import com.bobocode.controller.HelloJspController;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{HelloJspController.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ResolverConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
