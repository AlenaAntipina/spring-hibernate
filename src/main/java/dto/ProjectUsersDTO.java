package dto;

import entity.Employee;

import java.util.List;
import java.util.Objects;

public class ProjectUsersDTO {
    private String project;
    private List<Employee> employees;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectUsersDTO)) return false;
        ProjectUsersDTO that = (ProjectUsersDTO) o;
        return project.equals(that.project) && employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, employees);
    }

    @Override
    public String toString() {
        return "ProjectUsersDTO{" +
                "project='" + project + '\'' +
                ", employees=" + employees +
                '}';
    }
}
