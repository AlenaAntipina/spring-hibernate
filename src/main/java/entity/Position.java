package entity;

import javax.persistence.*;

@Entity
@Table(name="positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="position_id")
    private int id;

    @Column(name="positionname")
    private String position;

    public Position() {
    }

    public Position(String position) {
        this.position = position;
    }

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
}
