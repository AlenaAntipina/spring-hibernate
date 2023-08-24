package service;

import dao.EmployeeDAOImpl;
import dto.UserPositionDTO;
import dto.UserProjectsDTO;
import entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    private UserPositionDTO convertToUserPositionDTO(Employee employee) {
        UserPositionDTO userPositionDTO = new UserPositionDTO();
        userPositionDTO.setUsername(employee.getName());
        userPositionDTO.setLastname(employee.getLastname());
        userPositionDTO.setPosition(employee.getPosition().getPosition());
        return userPositionDTO;
    }

    private UserProjectsDTO convertToUserProjectsDTO(Employee employee) {
        UserProjectsDTO userProjectsDTO = new UserProjectsDTO();
        userProjectsDTO.setName(employee.getName());
        userProjectsDTO.setLastname(employee.getLastname());
        userProjectsDTO.setProjects(employee.getProjects());
        return userProjectsDTO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public List<UserProjectsDTO> getUserProjectsByName(String name, String lastname) {
        return employeeDAO.getEmployeeProjectsByName(name, lastname)
                .stream()
                .map(this::convertToUserProjectsDTO)
                .collect(Collectors.toList());
    }

    public List<UserPositionDTO> getEmployeeByPosition(String position) {
        return employeeDAO.getEmployeeByPosition(position)
                .stream()
                .map(this::convertToUserPositionDTO)
                .collect(Collectors.toList());
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }
}
