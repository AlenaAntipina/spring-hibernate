package dao;

import entity.Project;

import java.util.List;

public interface ProjectDAO {
    public void addProject(Project project);

    public List<Project> getAllProjects();

    public Project getProjectById(int id);

    public void updateProject(Project project);

    public void deleteProject(Project project);
}
