import config.DbConnection;
import entity.Employee;
import entity.EmployeeProject;
import entity.Position;
import entity.Project;
import service.EmployeeProjectService;
import service.EmployeeService;
import service.PositionService;
import service.ProjectService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hey");

//        Connection connection = DbConnection.getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM positions");
//            rs.next();
//            System.out.println( rs.getString(1) + " " + rs.getString(2));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        EmployeeService employeeService = new EmployeeService();
        EmployeeProjectService employeeProjectService = new EmployeeProjectService();
        PositionService positionService = new PositionService();
        ProjectService projectService = new ProjectService();

        System.out.println("EMPLOYEES");
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " " + emp.getLastname() + " - " + emp.getPosition());
        }

        System.out.println("\nEMPLOYEES AND PROJECTS");
        List<EmployeeProject> employeeProjects = employeeProjectService.getAllEmployeeProjects();
        for (EmployeeProject emplproj : employeeProjects) {
            System.out.println(emplproj.getName() + " " + emplproj.getLastname() + " - " + emplproj.getProject());
        }

        System.out.println("\nPROJECTS");
        List<Project> projects = projectService.getAllProjects();
        for (Project pr : projects) {
            System.out.println(pr.getProject());
        }

        System.out.println("\nPOSITIONS");
        List<Position> positions = positionService.getAllPositions();
        for (Position pos : positions) {
            System.out.println(pos.getPosition());
        }

        try {
            Connection connection = DbConnection.getConnection();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
