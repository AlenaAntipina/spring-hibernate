package service;

import config.DbConnection;
import dao.EmployeeDAO;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeDAO {

    private final Connection connection = DbConnection.getConnection();

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee " +
                "(employeename, employeelastname, position_id)" +
                "VALUES (?, ? ,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setInt(3, employee.getPositionId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
                "JOIN positions ON employee.position_id = positions.position_id";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString("employeename"),
                        resultSet.getString("employeelastname"),
                        resultSet.getString("positionname"));

                employees.add(employee);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
                "JOIN positions ON employee.position_id = positions.position_id\n" +
                "WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setName(resultSet.getString("employeename"));
            employee.setLastname(resultSet.getString("employeelastname"));
            employee.setPosition(resultSet.getString("positionname"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET employeename = ?, employeelastname = ?, position_id = ? where employee_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setInt(3, employee.getPositionId());
            preparedStatement.setInt(4, employee.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
