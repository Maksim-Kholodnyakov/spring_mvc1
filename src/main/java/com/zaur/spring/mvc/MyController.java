package com.zaur.spring.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test/")
public class MyController {

    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetail(Model model) {

        /*
        Employee emp = new Employee();
        emp.setName("Test1");
        emp.setSurname("Testov1");
        emp.setSalary(123456);
        model.addAttribute("employee",emp);
        данные в форме по дефолту будут с этого бина
         */
        model.addAttribute("employee",new Employee());

        return "ask-employee-detail";
    }

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetail() {
//        return "show-employee-detail";
//    }


//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//        String empName = request.getParameter("employeeName");
//        empName = "Mr." + empName;
//        model.addAttribute("nameAttribute", empName);
//        return "show-employee-detail";
//    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp) {

        String name = emp.getName();
        emp.setName("Mr" + name);
        return "show-employee-detail";
    }

}
