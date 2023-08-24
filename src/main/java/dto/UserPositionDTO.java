package dto;

import java.util.Objects;

public class UserPositionDTO {
    private String username;
    private String lastname;
    private String position;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPositionDTO)) return false;
        UserPositionDTO that = (UserPositionDTO) o;
        return username.equals(that.username) && lastname.equals(that.lastname) && position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, lastname, position);
    }

    @Override
    public String toString() {
        return "UserPositionDTO{" +
                "username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
