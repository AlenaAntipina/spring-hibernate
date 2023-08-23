//package controller;
//
//import entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import service.EmployeeService;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/employee")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/list")
//    public String listEmployees(Model theModel) {
//        List<Employee> employees = employeeService.getEmployees();
//        theModel.addAttribute("employees", employees);
//        return "list-employees";
//    }
//
//    @GetMapping("/showForm")
//    public String showFormForAdd(Model theModel) {
//        Employee employee = new Employee();
//        theModel.addAttribute("employee", employee);
//        return "employee-form";
//    }
//
//    @PostMapping("/saveEmployee")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//        employeeService.saveEmployee(employee);
//        return "redirect:/employee/list";
//    }
//
//    @GetMapping("/updateForm")
//    public String showFormForUpdate(@RequestParam("employeeId") int id,
//                                    Model theModel) {
//        Employee employee = employeeService.getEmployee(id);
//        theModel.addAttribute("employee", employee);
//        return "employee-form";
//    }
//
//    @GetMapping("/delete")
//    public String deleteEmployee(@RequestParam("employeeId") int id) {
//        employeeService.deleteEmployee(id);
//        return "redirect:/employee/list";
//    }
//}
