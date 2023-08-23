package dao;

import entity.EmployeeProject;

import java.util.List;

public interface EmployeeProjectDAO {
    public void addEmployeeProject(EmployeeProject employeeProject);

    public List<EmployeeProject> getAllEmployeeProjects();

    public EmployeeProject getEmployeeProjectById(int id);

    public void updateEmployeeProject(EmployeeProject employeeProject);

    public void deleteEmployeeProject(int id);
}
