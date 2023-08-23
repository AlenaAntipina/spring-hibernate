package dao;

import entity.Position;

import java.util.List;

public interface PositionDAO {
    public void addPosition(Position position);

    public List<Position> getAllPositions();

    public Position getPositionById(int id);

    public void updatePosition(Position position);

    public void deletePosition(int id);
}
