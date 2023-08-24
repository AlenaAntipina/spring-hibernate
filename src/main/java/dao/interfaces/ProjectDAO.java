package dao.interfaces;

import entity.Project;

import java.util.List;

public interface ProjectDAO {
    void addProject(Project project);

    Project getProjectById(int id);

    List<Project> getProjectAllUsers(String projectName);

    void updateProject(Project project);

    void deleteProject(Project project);
}
