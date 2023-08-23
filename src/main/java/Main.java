import config.HibernateUtil;
import entity.Employee;
import entity.Position;
import entity.Project;
import service.EmployeeService;
import service.PositionService;
import service.ProjectService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Position position = new Position();
//        position.setPosition("frontend developer");
//
//        session.save(position);
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();

        EmployeeService employeeService = new EmployeeService();
        PositionService positionService = new PositionService();
        ProjectService projectService = new ProjectService();

        System.out.println("\nEMPLOYEES");
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " " + emp.getLastname() + " - " + emp.getPosition().getPosition());
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

        HibernateUtil.shutdown();

    }
}
