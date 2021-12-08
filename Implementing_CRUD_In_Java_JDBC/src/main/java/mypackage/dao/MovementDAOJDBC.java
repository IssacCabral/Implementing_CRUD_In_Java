package mypackage.dao;

import mypackage.entity.Movement;
import mypackage.entity.TypeMovement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MovementDAOJDBC implements IMovementDAO{
    private final Connection connection;

    public MovementDAOJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Movement movement) {
        String sql = "INSERT INTO movement(product_id, quantity_movement, type) VALUES" +
                     "(?, ?, ?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movement.getProductId());
            ps.setInt(2, movement.getQuantity_movement());
            ps.setString(3, movement.getType().type_value);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Movement> listAll() {
        return null;
    }

    @Override
    public void findById(Integer id) {

    }
}
