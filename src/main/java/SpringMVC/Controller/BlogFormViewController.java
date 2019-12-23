package SpringMVC.Controller;

import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.RetrieveSingleBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/post")
public class BlogFormViewController {
    @RequestMapping(value = "/view",method = RequestMethod.POST)
    public ModelAndView showMyblog(@RequestParam("BlogId") String id)
    {
        int blogid = Integer.parseInt(id);
        RetrieveSingleBlog retrieveSingleBlog= new RetrieveSingleBlog();
        BlogModel blogModel=retrieveSingleBlog.getMyBlog(blogid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("ViewBlog",blogModel);
        modelAndView.setViewName("DisplayBlog");
        return modelAndView;
    }
}
