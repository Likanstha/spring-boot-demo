package com.crud.json.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.json.constant.PageConstant;
import com.crud.json.service.EmployeeService;

@Controller
@RequestMapping()
public class HomeController {
    @Autowired
    private EmployeeService employeeServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("totalEmployee", employeeServiceImpl.findTotalNo());
        return PageConstant.PAGE_HOME;
    }
}
