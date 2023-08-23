package dao;

import entity.Project;

import java.util.List;

public interface ProjectDAO {
    public void addProject(Project project);

    public List<Project> getAllProjects();

    public Project getEProjectById(int id);

    public void updateProject(Project project);

    public void deleteProject(int id);
}
