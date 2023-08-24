package service;

import dao.ProjectDAOImpl;
import dto.ProjectUsersDTO;
import entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private ProjectDAOImpl projectDAO = new ProjectDAOImpl();

    private ProjectUsersDTO convertToProjectUsersDTO(Project project) {
        ProjectUsersDTO projectUsersDTO = new ProjectUsersDTO();
        projectUsersDTO.setProject(project.getProject());
        projectUsersDTO.setEmployees(project.getEmployees());
        return projectUsersDTO;
    }

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    public List<ProjectUsersDTO> getProjectUsers(String project) {
        return projectDAO.getProjectAllUsers(project)
                .stream()
                .map(this::convertToProjectUsersDTO)
                .collect(Collectors.toList());
    }

    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }

    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    public void deleteProject(Project project) {
        projectDAO.deleteProject(project);
    }
}
