package service;

import config.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    @Override
    public void addProject(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Project> getAllProjects() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM project";
//        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
//                "JOIN positions ON employee.position_id = positions.position_id";


        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projects = query.list();

        //close session with a transaction
        closeTransactionSession();

        return projects;
    }

    @Override
    public Project getProjectById(int id) {
//        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
//                "JOIN positions ON employee.position_id = positions.position_id\n" +
//                "WHERE id = ?";

        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM project WHERE project_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return project;
    }

    @Override
    public void updateProject(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void deleteProject(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        //close session with a transaction
        closeTransactionSession();
    }
}
