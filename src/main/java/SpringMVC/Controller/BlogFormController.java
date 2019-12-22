package SpringMVC.Controller;

import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.PersistBlog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class BlogFormController {
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String showBlogAddForm(Model model)
    {
        BlogModel blogModel = new BlogModel();
        model.addAttribute("BlogModel", blogModel);
        return "addYourBlog";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView processStudentForm(@Valid @ModelAttribute("BlogModel") BlogModel blogModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView= new ModelAndView();
            modelAndView.setViewName("addYourBlog");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            PersistBlog PersistBlog = new PersistBlog();
            String result = PersistBlog.addThis(blogModel);
            modelAndView.setViewName("addYourBlog");
            modelAndView.addObject("processResult",result);
            return modelAndView;

        }
    }
}
