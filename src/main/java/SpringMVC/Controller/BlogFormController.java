package SpringMVC.Controller;

import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.*;
import SpringMVC.ServiceLayer.Interface.RetrieveInterface;
import SpringMVC.ServiceLayer.Interface.UpdateBlogInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    @RequestMapping(value = "/delete/{BlogId}",method = RequestMethod.GET)
    public ModelAndView deletedBlog(@PathVariable("BlogId") String blogId)
    {
        System.out.println(blogId+"sdvvvvvvvv");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("DeleteBlog");
        RetrieveInterface retrieveSingleBlog = new RetrieveBlog();
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

    @RequestMapping(value = "/update/{BlogId}",method = RequestMethod.GET)
    public ModelAndView updateBlog(@PathVariable("BlogId") String id)
    {
        int blogId = Integer.parseInt(id);
        RetrieveInterface retrieveSingleBlog = new RetrieveBlog();
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
        UpdateBlogInterface updateBlog= new UpdateBlog();
        updateBlog.updateMyblog(blogModel);
        RetrieveInterface retrieveBlog= new RetrieveBlog();
        modelAndView.addObject("BlogData",retrieveBlog.getBlogData());
        modelAndView.setViewName("DataSucess");
        return modelAndView;
    }
    @RequestMapping(value = "/view/{BlogId}",method = RequestMethod.GET)
    public ModelAndView showMyblog(@PathVariable("BlogId") String id)
    {
        int blogid = Integer.parseInt(id);
        RetrieveInterface retrieveSingleBlog= new RetrieveBlog();
        BlogModel blogModel=retrieveSingleBlog.getMyBlog(blogid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("ViewBlog",blogModel);
        modelAndView.setViewName("DisplayBlog");
        return modelAndView;
    }


}
