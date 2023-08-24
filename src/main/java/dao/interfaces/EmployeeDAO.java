package dao.interfaces;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    List<Employee> getEmployeeByPosition(String position);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}


