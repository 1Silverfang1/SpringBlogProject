package SpringMVC;

import SpringMVC.Configuration.ApplicationContextConfig;
import SpringMVC.ServiceLayer.DeleteBlog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args)
    {
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        DeleteBlog deleteBlog= applicationContext.getBean(DeleteBlog.class);
        System.out.println("Bean created");
    }
}
