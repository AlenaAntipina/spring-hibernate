package dao;

import entity.Employee;

import java.util.List;

public interface ModelDAO {
    public List<Employee> getEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
