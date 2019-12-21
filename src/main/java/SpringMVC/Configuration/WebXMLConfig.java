package SpringMVC.Configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXMLConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationContextConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
