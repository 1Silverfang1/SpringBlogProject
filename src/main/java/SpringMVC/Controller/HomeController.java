package SpringMVC.Controller;

import SpringMVC.Configuration.ApplicationContextConfig;
import SpringMVC.ServiceLayer.Interface.RetrieveInterface;
import SpringMVC.ServiceLayer.RetrieveBlog;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getMyHomePage()
    {
        RetrieveInterface retrieveBlog = new RetrieveBlog();
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("BlogData",retrieveBlog.getBlogData());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
