package SpringMVC.Controller;

import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.RetrieveBlog;
import SpringMVC.ServiceLayer.RetrieveSingleBlog;
import SpringMVC.ServiceLayer.UpdateBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/post")
public class BlogFormUpdateController {

    @RequestMapping(value = "/update/{BlogId}",method = RequestMethod.GET)
    public ModelAndView updateBlog(@PathVariable("BlogId") String id)
    {
        int blogId = Integer.parseInt(id);
        RetrieveSingleBlog retrieveSingleBlog = new RetrieveSingleBlog();
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("BlogObject",retrieveSingleBlog.getMyBlog(blogId));
//        System.out.println(request.getParameter("BlogId")+"svd");
        modelAndView.addObject("BlogId",id);
        modelAndView.setViewName("UpdateBlog");
        return  modelAndView;
    }
    @RequestMapping(value = "updateConfirm",method = RequestMethod.POST)
    public ModelAndView updatemyBlog(@ModelAttribute BlogModel blogModel)
    {
        System.out.println(blogModel);
        ModelAndView modelAndView= new ModelAndView();
        UpdateBlog updateBlog= new UpdateBlog();
        updateBlog.updateMyblog(blogModel);
        RetrieveBlog retrieveBlog= new RetrieveBlog();
        modelAndView.addObject("BlogData",retrieveBlog.getBlogData());
        modelAndView.setViewName("DataSucess");
        return modelAndView;
    }
}
