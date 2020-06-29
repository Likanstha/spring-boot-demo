package com.crud.json.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.crud.json.constant.PageConstant;
import com.crud.json.constant.UrlConstant;
import com.crud.json.entity.Employee;
import com.crud.json.service.EmployeeService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
@RequestMapping(UrlConstant.URL_employee)
public class EmployeeController {

    private static final Logger LOG = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private EmployeeService employeeServiceImpl;


    @RequestMapping(value = UrlConstant.URL_LIST, method = RequestMethod.GET)
    public String list(Model model) {

        List<Employee> employees = employeeServiceImpl.findAll();
        model.addAttribute("employees", employees);
        return PageConstant.PAGE_employee_LIST;
    }


    @RequestMapping(value = UrlConstant.URL_CREATE, method = RequestMethod.GET)
    public String createForm(Model model) {
        LOG.info("Inside employeeController#createForm() method");
        if (!model.containsAttribute("employee")) {
            model.addAttribute("employee", new Employee());
        }
        return PageConstant.PAGE_employee_CREATE;
    }


    @RequestMapping(value = UrlConstant.URL_CREATE, method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
                       RedirectAttributes redirectAttributes) {
        LOG.info("Inside employeeController#save() method");
        if (result.hasErrors()) {
            LOG.debug("AccountLedger validation errors : " + result);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employee", result);
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("error.employee.create", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_CREATE;
        }
        try {
        	System.out.println("1111111111111");

           
            employeeServiceImpl.save(employee);
            System.out.println("1111111111111");
            redirectAttributes.addFlashAttribute("success",
                    messageSource.getMessage("success.employee.create", null, Locale.getDefault()));
            System.out.println("1111111111111");
            LOG.info("employee save successfully");
            System.out.println(employee.getName());
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_VIEW + "/" + employee.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("exception.employee.create", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_CREATE;
        }

    }


    @RequestMapping(value = UrlConstant.URL_VIEW_ID, method = RequestMethod.GET)
    public String view(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        LOG.info("Inside employeeController#view() method");
        Employee employee = employeeServiceImpl.findById(id);
        if (employee == null) {
            LOG.debug("employee doesnot exist with id " + id);
            redirectAttributes.addFlashAttribute("info",
                    messageSource.getMessage("exist.not.employee", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_LIST;
        }
        model.addAttribute("employee", employee);
        return PageConstant.PAGE_employee_VIEW;
    }


    @RequestMapping(value = UrlConstant.URL_EDIT_ID, method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        LOG.info("Inside employeeController#edit() method");
        Employee employee = employeeServiceImpl.findById(id);
        if (employee == null) {
            LOG.debug("employee doesnot exist with id " + id);
            redirectAttributes.addFlashAttribute("info",
                    messageSource.getMessage("exist.not.employee", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_LIST;
        }
        model.addAttribute("employee", employee);
        return PageConstant.PAGE_employee_EDIT;
    }


    @RequestMapping(value = UrlConstant.URL_UPDATE, method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
                         RedirectAttributes redirectAttributes) {
        LOG.info("Inside employeeController#update() method");
        Employee dbemployee = employeeServiceImpl.findById(employee.getId());
        if (dbemployee == null) {
            LOG.debug("employee doesnot exist with id " + employee.getId());
            redirectAttributes.addFlashAttribute("info",
                    messageSource.getMessage("exist.not.employee", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_LIST;
        }
        if (result.hasErrors()) {
            LOG.debug("AccountLedger validation errors : " + result);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employee", result);
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("error.employee.update", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_EDIT + "/" + employee.getId();
        }

        dbemployee.setName(employee.getName());
        dbemployee.setPhone(employee.getPhone());
        dbemployee.setAddress(employee.getAddress());
        dbemployee.setDesignation(employee.getDesignation());
        dbemployee.setSalary(employee.getSalary());
        dbemployee.setEmail(employee.getEmail());
        try {
            employeeServiceImpl.update(employee);
            redirectAttributes.addFlashAttribute("success",
                    messageSource.getMessage("success.employee.update", null, Locale.getDefault()));
            LOG.info("employee updated successfully");
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_VIEW + "/" + dbemployee.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("exception.employee.update", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_EDIT + "/" + employee.getId();
        }
    }


    @RequestMapping(value = UrlConstant.URL_DELETE, method = RequestMethod.POST)
    public String delete(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        LOG.info("Inside employeeController#delete() method ");
        Employee employee = employeeServiceImpl.findById(id);
        if (employee == null) {
            LOG.debug("employee doesnot exist with id " + id);
            redirectAttributes.addFlashAttribute("info",
                    messageSource.getMessage("exist.not.employee", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_LIST;
        }
        try {
            employeeServiceImpl.delete(employee);
            redirectAttributes.addFlashAttribute("success",
                    messageSource.getMessage("success.employee.delete", null, Locale.getDefault()));
            LOG.info("employee deleted successfully with id " + id);
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_LIST;
        } catch (Exception e) {
            LOG.error("employee cannot deleted due to {}", e);
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("exception.employee.delete", null, Locale.getDefault()));
            return "redirect:" + UrlConstant.URL_employee + UrlConstant.URL_VIEW + "/" + employee.getId();
        }
    }

}
