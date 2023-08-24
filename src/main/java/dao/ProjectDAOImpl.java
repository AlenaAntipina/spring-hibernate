package dao;

import utils.SessionUtil;
import dao.interfaces.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDAOImpl extends SessionUtil implements ProjectDAO {

    @Override
    public void addProject(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.save(project);
        closeTransactionSession();
    }

    @Override
    public Project getProjectById(int id) {
        openTransactionSession();

        String sql = "SELECT * FROM project WHERE project_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();
        closeTransactionSession();

        return project;
    }

    public List<Project> getProjectAllUsers(String projectName) {
        openTransactionSession();

        String sql = "SELECT * FROM employee\n" +
                "JOIN employee_project ON employee_project.employee_id = employee.employee_id\n" +
                "JOIN project ON employee_project.project_id = project.project_id\n" +
                "WHERE projectname = :projectName";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("projectName", projectName);

        List<Project> projectUsers = query.list();
        closeTransactionSession();

        return projectUsers;
    }

    @Override
    public void updateProject(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.update(project);
        closeTransactionSession();
    }

    @Override
    public void deleteProject(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.remove(project);
        closeTransactionSession();
    }
}
