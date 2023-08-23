package service;

import config.DbConnection;
import dao.ProjectDAO;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService implements ProjectDAO {
    private final Connection connection = DbConnection.getConnection();

    @Override
    public void addProject(Project project) {
        String sql = "INSERT INTO project (projectname) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, project.getProject());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT projectname FROM project";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project(resultSet.getString("projectname"));

                projects.add(project);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }

    @Override
    public Project getEProjectById(int id) {
        Project project = new Project();
        String sql = "SELECT projectname FROM project WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            project.setProject(resultSet.getString("projectname"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return project;
    }

    @Override
    public void updateProject(Project project) {
        String sql = "UPDATE project SET projectname = ? where project_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, project.getProject());
            preparedStatement.setInt(2, project.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(int id) {
        String sql = "DELETE FROM project WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
