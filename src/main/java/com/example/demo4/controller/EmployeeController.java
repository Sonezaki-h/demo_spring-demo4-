package com.example.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo4.domain.Employee;
import com.example.demo4.service.EmployeeService;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/execute")
    public String execute(Model model) {
        Employee employee = new Employee();
        employee.setName("山田太郎");
        employee.setAge(20);
        employee.setGender("男");
        employee.setDepartmentId(1);
        service.save(employee);

        Employee employee2 = service.laod(3);
        System.out.println(employee2);
        service.deleteById(3);
        service.findAll().forEach(System.out::println);
        model.addAttribute("employee",employee);
        return "finished";

    }

}
