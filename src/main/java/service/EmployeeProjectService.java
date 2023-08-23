package service;

import config.DbConnection;
import dao.EmployeeProjectDAO;
import entity.EmployeeProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectService implements EmployeeProjectDAO {
    private final Connection connection = DbConnection.getConnection();

    @Override
    public void addEmployeeProject(EmployeeProject employeeProject) {
        String sql = "INSERT INTO employee_project " +
                "(employe_id, project_id)" +
                "VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, employeeProject.getEmployeeId());
            preparedStatement.setInt(2, employeeProject.getProjectId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeProject> getAllEmployeeProjects() {
        List<EmployeeProject> employeeProjects = new ArrayList<>();
        String sql = "SELECT employeename, employeelastname, projectname FROM employee_project\n" +
                "JOIN employee ON employee.employee_id = employee_project.employee_id\n" +
                "JOIN project ON project.project_id = employee_project.project_id";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmployeeProject employeeProject = new EmployeeProject(
                        resultSet.getString("employeename"),
                        resultSet.getString("employeelastname"),
                        resultSet.getString("projectname"));

                employeeProjects.add(employeeProject);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeProjects;
    }

    @Override
    public EmployeeProject getEmployeeProjectById(int id) {
        EmployeeProject employeeProject = new EmployeeProject();
        String sql = "SELECT employeename, employeelastname, projectname FROM employee_project\n" +
                "JOIN employee ON employee.employee_id = employee_project.employee_id\n" +
                "JOIN project ON project.project_id = employee_project.project_id where id = 11";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            employeeProject.setName(resultSet.getString("employeename"));
            employeeProject.setLastname(resultSet.getString("employeelastname"));
            employeeProject.setProject(resultSet.getString("projectname"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeProject;
    }

    @Override
    public void updateEmployeeProject(EmployeeProject employeeProject) {
        String sql = "UPDATE employee_project SET employe_id = ?, project_id = ? where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, employeeProject.getEmployeeId());
            preparedStatement.setInt(2, employeeProject.getProjectId());
            preparedStatement.setLong(3, employeeProject.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeProject(int id) {
        String sql = "DELETE FROM employee_project WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
