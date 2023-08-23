package service;

import config.SessionUtil;
import dao.PositionDAO;
import entity.Employee;
import entity.Position;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionService extends SessionUtil implements PositionDAO {
    @Override
    public void addPosition(Position position) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(position);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Position> getAllPositions() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM positions";
//        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
//                "JOIN positions ON employee.position_id = positions.position_id";


        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Position.class);
        List<Position> positions = query.list();

        //close session with a transaction
        closeTransactionSession();

        return positions;
    }

    @Override
    public Position getPositionById(int id) {
//        String sql = "SELECT employeename, employeelastname, positionname FROM employee\n" +
//                "JOIN positions ON employee.position_id = positions.position_id\n" +
//                "WHERE id = ?";

        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM positions WHERE position_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);

        Position position = (Position) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return position;
    }

    @Override
    public void updatePosition(Position position) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(position);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void deletePosition(Position position) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(position);

        //close session with a transaction
        closeTransactionSession();
    }
}
