package SpringMVC.Controller;

import SpringMVC.Configuration.ApplicationContextConfig;
import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.*;
import SpringMVC.ServiceLayer.Interface.DeleteBlogInterface;
import SpringMVC.ServiceLayer.Interface.RetrieveInterface;
import SpringMVC.ServiceLayer.Interface.SaveBlogInterface;
import SpringMVC.ServiceLayer.Interface.UpdateBlogInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
//            ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Application.xml")
            ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
            SaveBlogInterface PersistBlog = applicationContext.getBean(PersistBlog.class);
            String result = PersistBlog.addThis(blogModel);
            modelAndView.setViewName("blogAdded");
            modelAndView.addObject("processResult",result);
            return modelAndView;

        }
    }
    @RequestMapping(value = "/delete/{BlogId}",method = RequestMethod.GET)
    public ModelAndView deletedBlog(@PathVariable("BlogId") String blogId)
    {
//        System.out.println(blogId+"sdvvvvvvvv");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("DeleteBlog");
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        RetrieveInterface retrieveSingleBlog = applicationContext.getBean(RetrieveBlog.class);
        modelAndView.addObject("BlogObject",retrieveSingleBlog.getMyBlog(Integer.parseInt(blogId)));
        return  modelAndView;
    }
    @RequestMapping(value = "/delete/Confirm",method = RequestMethod.POST)
    public ModelAndView deletedConfirmBlog(@RequestParam("blogId") String id)
    {

        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        DeleteBlogInterface Blog= applicationContext.getBean(DeleteBlog.class);
        Blog.deleteBlog(Integer.parseInt(id));
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("dataDeleted");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{BlogId}",method = RequestMethod.GET)
    public ModelAndView updateBlog(@PathVariable("BlogId") String id)
    {
        int blogId = Integer.parseInt(id);
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        RetrieveInterface retrieveSingleBlog = applicationContext.getBean(RetrieveBlog.class);
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
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        UpdateBlogInterface updateBlog= applicationContext.getBean(UpdateBlog.class);
        updateBlog.updateMyblog(blogModel);
        RetrieveInterface retrieveBlog= applicationContext.getBean(RetrieveBlog.class);
        modelAndView.addObject("BlogData",retrieveBlog.getBlogData());
        modelAndView.setViewName("DataSucess");
        return modelAndView;
    }
    @RequestMapping(value = "/view/{BlogId}",method = RequestMethod.GET)
    public ModelAndView showMyblog(@PathVariable("BlogId") String id)
    {
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        int blogid = Integer.parseInt(id);
        RetrieveInterface retrieveSingleBlog= applicationContext.getBean(RetrieveBlog.class);
        BlogModel blogModel=retrieveSingleBlog.getMyBlog(blogid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("ViewBlog",blogModel);
        modelAndView.setViewName("DisplayBlog");
        return modelAndView;
    }


}
