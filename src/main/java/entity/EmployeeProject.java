package entity;

import javax.persistence.*;

@Entity
@Table(name="employee_project")
public class EmployeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="project_id")
    private int projectId;

    private String project;

    private String name;

    private String lastname;

    public EmployeeProject() {
    }

    public EmployeeProject(String name, String lastname, String project) {
        this.name = name;
        this.lastname = lastname;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

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
}
