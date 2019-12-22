package SpringMVC.Controller;

import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class BlogFormController {
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String BlogAddForm(Model model)
    {
        BlogModel blogModel = new BlogModel();
        model.addAttribute("BlogModel", blogModel);
        return "addYourBlog";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView processBlog(@Valid @ModelAttribute("BlogModel") BlogModel blogModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView= new ModelAndView();
            modelAndView.setViewName("addYourBlog");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            PersistBlog PersistBlog = new PersistBlog();
            String result = PersistBlog.addThis(blogModel);
            modelAndView.setViewName("blogAdded");
            modelAndView.addObject("processResult",result);
            return modelAndView;

        }
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ModelAndView deletedBlog(HttpServletRequest request)
    {
//        System.out.println(request.getParameter("BlogId"));
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("DeleteBlog");
       RetrieveSingleBlog retrieveSingleBlog = new RetrieveSingleBlog();
       modelAndView.addObject("BlogObject",retrieveSingleBlog.getMyBlog(Integer.parseInt(request.getParameter("BlogId"))));
        return  modelAndView;
    }
    @RequestMapping(value = "/delete/Confirm",method = RequestMethod.POST)
    public ModelAndView deletedConfirmBlog(HttpServletRequest request)
    {
        System.out.println(request.getParameter("blogId"));
        DeleteBlog Blog= new DeleteBlog();
        Blog.deleteBlog(Integer.parseInt(request.getParameter("blogId")));
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("dataDeleted");
        return modelAndView;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView updateBlog(HttpServletRequest request)
    {
            RetrieveSingleBlog retrieveSingleBlog = new RetrieveSingleBlog();
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("BlogObject",retrieveSingleBlog.getMyBlog(Integer.parseInt(request.getParameter("BlogId"))));
//        System.out.println(request.getParameter("BlogId")+"svd");
        modelAndView.addObject("BlogId",request.getParameter("BlogId"));
       modelAndView.setViewName("UpdateBlog");
        return  modelAndView;
    }
    @RequestMapping("updateConfirm")
    public ModelAndView updatemyBlog(@ModelAttribute BlogModel blogModel)
    {
        //System.out.println(blogModel);
            ModelAndView modelAndView= new ModelAndView();
            UpdateBlog updateBlog= new UpdateBlog();
          updateBlog.updateMyblog(blogModel);
        RetrieveBlog retrieveBlog= new RetrieveBlog();
        modelAndView.addObject("BlogData",retrieveBlog.getBlogData());
        modelAndView.setViewName("DataSucess");
        return modelAndView;
    }
    @RequestMapping(value = "/view",method = RequestMethod.POST)
    public ModelAndView showMyblog(HttpServletRequest request)
    {
        int id = Integer.parseInt(request.getParameter("BlogId"));
        RetrieveSingleBlog retrieveSingleBlog= new RetrieveSingleBlog();
        BlogModel blogModel=retrieveSingleBlog.getMyBlog(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("ViewBlog",blogModel);
        modelAndView.setViewName("DisplayBlog");
        return modelAndView;
    }
}
