package dto;

import entity.Project;

import java.util.List;
import java.util.Objects;

public class UserProjectsDTO {
    private String name;
    private String lastname;
    private List<Project> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProjectsDTO)) return false;
        UserProjectsDTO that = (UserProjectsDTO) o;
        return name.equals(that.name) && lastname.equals(that.lastname) && projects.equals(that.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, projects);
    }

    @Override
    public String toString() {
        return "UserProjectsDTO{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", projects=" + projects +
                '}';
    }
}
