package com.hremployees.controllers;

import com.hremployees.entities.ManagerEmployee;
import com.hremployees.exceptions.ResourceNotFoundException;
import com.hremployees.formaters.departementFormater;
import com.hremployees.formaters.normalEmployeeFormater;
import com.hremployees.formaters.remunerationFormater;
import com.hremployees.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RemunerationService remunerationService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private NormalEmployeeService normalEmployeeService;
    @Autowired
    private ManageremployeeService manageremployeeService;

    @InitBinder
    private void customizeBinding (WebDataBinder binder) {
        binder.registerCustomEditor(String.class,"departement", new departementFormater());
        binder.registerCustomEditor(String.class,"remuneration", new remunerationFormater());
        binder.registerCustomEditor(String.class,"normalEmployees", new normalEmployeeFormater());
    }

    @GetMapping({"/add"})
    public String add(ModelMap model, ManagerEmployee employee, HttpServletRequest request) {
        model.addAttribute("departement", departementService.getAllDeps());
        model.addAttribute("remuneration", remunerationService.getAllRumuneration());
        model.addAttribute("normalEmployees", normalEmployeeService.getAllNormalEmployee());
        model.addAttribute("employees", employee);
        return "employees/add";
    }

    @PostMapping("/saveManager")
    public String saveEmployee(@Valid @ModelAttribute("employees") ManagerEmployee employee, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        if(result.hasErrors()){
            model.addAttribute("departement", departementService.getAllDeps());
            model.addAttribute("remuneration", remunerationService.getAllRumuneration());
            model.addAttribute("employee",employee);
            return "employees/add";
        }
            manageremployeeService.save(employee);

        return "redirect:/home";
    }
    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable("id") long id, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        model.addAttribute("normalEmployees", normalEmployeeService.getAllNormalEmployee());
        model.addAttribute("departement", departementService.getAllDeps());
        model.addAttribute("remuneration", remunerationService.getAllRumuneration());
        model.addAttribute("employees",employeeService.findById(id));
        return "employees/EditManager";
    }

    @PostMapping({"/edit"})
    public String postEdit(@Valid @ModelAttribute("employees") ManagerEmployee employee, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        if(result.hasErrors()){
            model.addAttribute("departement", departementService.getAllDeps());
            model.addAttribute("remuneration", remunerationService.getAllRumuneration());
            model.addAttribute("employee",employee);
            return "employees/add";
        }
        // System.out.println("List des employées a ajouter :"+employee.getNormalEmployees().toString());
        manageremployeeService.save(employee);

        return "employees/add";
    }
}
