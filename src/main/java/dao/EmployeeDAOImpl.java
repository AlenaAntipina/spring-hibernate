package dao;

import utils.SessionUtil;
import dao.interfaces.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl extends SessionUtil implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        closeTransactionSession();
    }

    @Override
    public List<Employee> getAllEmployees() {
        openTransactionSession();

        String sql = "SELECT * FROM employee";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employees = query.list();
        closeTransactionSession();

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        openTransactionSession();

        String sql = "SELECT * FROM employee WHERE employee_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();
        closeTransactionSession();

        return employee;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        openTransactionSession();

        String sql = "SELECT * FROM employee " +
                "JOIN positions ON positions.position_id = employee.position_id " +
                "WHERE positionname = :position";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("position", position);

        List<Employee> employees = query.list();
        closeTransactionSession();

        return employees;
    }

    public List<Employee> getEmployeeProjectsByName(String name, String lastname) {
        openTransactionSession();

        String sql = "SELECT * FROM employee\n" +
                "JOIN employee_project ON employee_project.employee_id = employee.employee_id\n" +
                "JOIN project ON employee_project.project_id = project.project_id\n" +
                "WHERE employeename = :name and employeelastname = :lastname";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("name", name);
        query.setParameter("lastname", lastname);

        List<Employee> employeesAndProjects = query.list();
        closeTransactionSession();

        return employeesAndProjects;
    }

    @Override
    public void updateEmployee(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.update(employee);
        closeTransactionSession();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);
        closeTransactionSession();
    }
}
