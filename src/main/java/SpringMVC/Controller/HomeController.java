package SpringMVC.Controller;

import SpringMVC.ServiceLayer.RetrieveBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getMyHomePage()
    {
        ModelAndView modelAndView= new ModelAndView();
        RetrieveBlog retrieveBlog= new RetrieveBlog();
        modelAndView.addObject("BlogData",retrieveBlog.getBlogData());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
