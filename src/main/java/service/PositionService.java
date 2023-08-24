package service;

import dao.PositionDAOImpl;
import entity.Position;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    PositionDAOImpl positionDAO = new PositionDAOImpl();

    public void addPosition(Position position) {
        positionDAO.addPosition(position);
    }

    public Position getPositionById(int id) {
        return positionDAO.getPositionById(id);
    }

    public void updatePosition(Position position) {
        positionDAO.updatePosition(position);
    }

    public void deletePosition(Position position) {
        positionDAO.deletePosition(position);
    }
}
