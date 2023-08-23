package entity;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_id")
    private int id;

    @Column(name="projectname")
    private String project;

    public Project() {
    }

    public Project(String project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
