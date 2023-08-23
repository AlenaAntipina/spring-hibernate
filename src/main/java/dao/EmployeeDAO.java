package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);
}


