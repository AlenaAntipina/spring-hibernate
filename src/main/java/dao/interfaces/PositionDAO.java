package dao.interfaces;

import entity.Position;

public interface PositionDAO {
    void addPosition(Position position);

    Position getPositionById(int id);

    void updatePosition(Position position);

    void deletePosition(Position position);
}
