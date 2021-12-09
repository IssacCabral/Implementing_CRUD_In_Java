package mypackage.dao;

import mypackage.dao.dao_interface.IMovementDAO;
import mypackage.entity.Movement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovementDAOJDBC implements IMovementDAO {
    private final Connection connection;

    public MovementDAOJDBC(Connection connection){
        this.connection = connection;
    }

    private Movement map(ResultSet rs) throws SQLException {
        Movement movement = new Movement(
                rs.getInt("id"),
                rs.getInt("product_id"),
                rs.getInt("quantity_movement"),
                rs.getString("type_movement"),
                rs.getDouble("price"),
                rs.getDate("date_movement")
        );
        return movement;
    }

    @Override
    public void create(Movement movement) {
        String sql = "INSERT INTO movement(product_id, quantity_movement, type_movement) VALUES" +
                     "(?, ?, ?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movement.getProductId());
            ps.setInt(2, movement.getQuantity_movement());
            ps.setString(3, movement.getTypeMovementString());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Movement> listAll(){
        String sql = "SELECT * FROM movement";
        List<Movement> movementList = new ArrayList<>();

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Movement movement = map(rs);
                movementList.add(movement);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return movementList;
    }

    @Override
    public Movement findById(Integer id) {
        String sql = "SELECT * FROM movement WHERE id = ?";
        Movement movement = null;

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                movement = map(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return movement;
    }
}
