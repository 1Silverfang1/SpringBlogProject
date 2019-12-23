package SpringMVC.Controller;

import SpringMVC.ServiceLayer.DeleteBlog;
import SpringMVC.ServiceLayer.RetrieveSingleBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/post")
public class BlogFormDeleteController {
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ModelAndView deletedBlog(@RequestParam("BlogId") String blogId)
    {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("DeleteBlog");
        RetrieveSingleBlog retrieveSingleBlog = new RetrieveSingleBlog();
        modelAndView.addObject("BlogObject",retrieveSingleBlog.getMyBlog(Integer.parseInt(blogId)));
        return  modelAndView;
    }
    @RequestMapping(value = "/delete/Confirm",method = RequestMethod.POST)
    public ModelAndView deletedConfirmBlog(@RequestParam("blogId") String id)
    {


        DeleteBlog Blog= new DeleteBlog();
        Blog.deleteBlog(Integer.parseInt(id));
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("dataDeleted");
        return modelAndView;
    }
}
