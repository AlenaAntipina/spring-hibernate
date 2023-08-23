package service;

import config.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Employee> getAllEmployees() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM employee";
//        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
//                "JOIN positions ON employee.position_id = positions.position_id";


        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employees = query.list();

        //close session with a transaction
        closeTransactionSession();

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
//        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
//                "JOIN positions ON employee.position_id = positions.position_id\n" +
//                "WHERE id = ?";

        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE WHERE employee_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        //close session with a transaction
        closeTransactionSession();
    }
}
