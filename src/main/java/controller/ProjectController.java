package controller;

import dto.ProjectUsersDTO;
import entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService = new ProjectService();

    @GetMapping("/users")
    @ResponseBody
    public List<ProjectUsersDTO> getAllUsersFromProject(@RequestParam String project) {
        List<ProjectUsersDTO> projectUsers = projectService.getProjectUsers(project);
        return projectUsers;
    }

    @PostMapping("/add")
    public void add(@RequestBody Project project) {
        projectService.addProject(project);
    }

    @PostMapping("/update")
    public void update(@RequestBody Project project) {
        projectService.updateProject(project);
    }

    @GetMapping("/delete")
    public void delete(@RequestBody Project project) {
        projectService.deleteProject(project);
    }
}
