package SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {
    @RequestMapping("/formPage")
    public String getMyFormPage()
    {
        return "formPage";
    }
    @RequestMapping("processMyForm")
    public String processMyForm()
    {
        return "formConfirmation";
    }
    @RequestMapping("processMyFormV1")
    public String processMyFormV1(HttpServletRequest request, Model model)
    {
        String firstName=request.getParameter("FirstName");
        String secondName= request.getParameter("LastName");
        firstName+= " is your First Name ";
        secondName+= " is your Last Name";
        model.addAttribute("yourName",firstName);
        model.addAttribute("yourLastName",secondName);
        return "formConfirmation";
    }
    @RequestMapping("processMyFormV2")
    public String processMyFormV2(  @RequestParam("FirstName") String firstName,Model model)
    {
//        String secondName= request.getParameter("LastName");
        firstName+= " is your First Name  v2 ";
  //      secondName+= " is your Last Name";
        model.addAttribute("yourName",firstName);
    //    model.addAttribute("yourLastName",secondName);
        return "formConfirmation";
    }
}
