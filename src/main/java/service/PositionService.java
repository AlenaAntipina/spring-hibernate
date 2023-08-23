package service;

import config.DbConnection;
import dao.PositionDAO;
import entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionService implements PositionDAO {
    private final Connection connection = DbConnection.getConnection();

    @Override
    public void addPosition(Position position) {
        String sql = "INSERT INTO positions (positionname) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, position.getPosition());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Position> getAllPositions() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT positionname FROM positions";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Position position = new Position(resultSet.getString("positionname"));

                positions.add(position);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return positions;
    }

    @Override
    public Position getPositionById(int id) {
        Position position = new Position();
        String sql = "SELECT positionname FROM positions WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            position.setPosition(resultSet.getString("positionname"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return position;
    }

    @Override
    public void updatePosition(Position position) {
        String sql = "UPDATE positions SET positionname = ? where position_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, position.getPosition());
            preparedStatement.setInt(2, position.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePosition(int id) {
        String sql = "DELETE FROM positions WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
