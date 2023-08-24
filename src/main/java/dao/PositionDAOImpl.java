package dao;

import utils.SessionUtil;
import dao.interfaces.PositionDAO;
import entity.Position;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PositionDAOImpl extends SessionUtil implements PositionDAO {
    @Override
    public void addPosition(Position position) {
        openTransactionSession();

        Session session = getSession();
        session.save(position);

        closeTransactionSession();
    }

    @Override
    public Position getPositionById(int id) {
        openTransactionSession();

        String sql = "SELECT * FROM positions WHERE position_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);

        Position position = (Position) query.getSingleResult();

        closeTransactionSession();

        return position;
    }

    @Override
    public void updatePosition(Position position) {
        openTransactionSession();

        Session session = getSession();
        session.update(position);

        closeTransactionSession();
    }

    @Override
    public void deletePosition(Position position) {
        openTransactionSession();

        Session session = getSession();
        session.remove(position);

        closeTransactionSession();
    }
}
