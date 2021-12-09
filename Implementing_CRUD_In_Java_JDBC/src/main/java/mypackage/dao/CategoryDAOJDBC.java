package mypackage.dao;

import mypackage.dao.dao_interface.ICategoryDAO;
import mypackage.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOJDBC implements ICategoryDAO {
    private final Connection connection;

    public CategoryDAOJDBC(Connection connection){
        this.connection = connection;
    }

    private Category map(ResultSet rs) throws SQLException {
        Category category = new Category(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getDate("date_category")
        );
        return category;
    }

    @Override
    public void create(Category category) {
        String sql = "INSERT INTO category (name) VALUES(?)";
        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> listAll() {
        String sql = "SELECT * FROM category";
        List<Category> categoryList = new ArrayList<>();

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category = map(rs);
                categoryList.add(category);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(Integer id) {
        String sql = "SELECT id, name, date_category FROM category WHERE id = ?";
        Category category = null;

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                category = map(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(Integer id, String name) {
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM category WHERE id = ?";
        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
