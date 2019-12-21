package SpringMVC;

import SpringMVC.Model.Student;
import SpringMVC.ServiceLayer.AddService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    public String showStudentForm(Model model)
    {
        Student student= new Student();
        model.addAttribute("studentModel",student);
        return "studentForm";
    }
    @RequestMapping("/processForm")
    public ModelAndView processStudentForm(@Valid @ModelAttribute("studentModel") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView= new ModelAndView();
            modelAndView.setViewName("studentForm");
            return modelAndView;
        } else {
//            System.out.println("Student First Name is : " + student.getFirstName());
//            System.out.println("Student Last Name is : " + student.getLastName());
//            System.out.println("Student Id is : " + student.getId());
            ModelAndView modelAndView = new ModelAndView();
            AddService addService= new AddService();

            String result =addService.addThis(student.getFirstName(),student.getLastName(),student.getId());
            modelAndView.setViewName("studentFormConfirm");
            modelAndView.addObject("processResult",result);
            return modelAndView;

        }
    }
}
