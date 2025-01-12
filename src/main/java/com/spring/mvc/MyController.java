package com.spring.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }



    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {


        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult) {

//        System.out.println("surname length " +  emp.getSurname().length());
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else return "show-emp-details-view";
    }

}
