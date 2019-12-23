package SpringMVC.Controller;

import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class BlogFormCreateController {
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


}
