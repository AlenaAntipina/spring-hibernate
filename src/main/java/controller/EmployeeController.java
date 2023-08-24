package controller;

import dto.UserPositionDTO;
import dto.UserProjectsDTO;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService = new EmployeeService();

    @GetMapping("/positions")
    @ResponseBody
    public List<UserPositionDTO> getUserByPosition(@RequestParam String position) {
        List<UserPositionDTO> usersPosition = employeeService.getEmployeeByPosition(position);
        return usersPosition;
    }

    @GetMapping("/projects")
    @ResponseBody
    public List<UserProjectsDTO> getAllUserProjects(String name, String lastname) {
        List<UserProjectsDTO> userProjects = employeeService.getUserProjectsByName(name, lastname);
        return userProjects;
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PostMapping("/update")
    public void update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @GetMapping("/delete")
    public void delete(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }
}
