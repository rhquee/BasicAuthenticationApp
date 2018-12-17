package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by kfrak on 15.12.2018.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
