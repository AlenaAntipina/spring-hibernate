package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    private int id;

    @Column(name="positionname")
    private String position;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    public Position() {
    }

//    public Position(String position) {
//        this.position = position;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}
