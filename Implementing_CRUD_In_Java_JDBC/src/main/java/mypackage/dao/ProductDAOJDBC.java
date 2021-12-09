package mypackage.dao;

import mypackage.dao.dao_interface.IProductDAO;
import mypackage.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOJDBC implements IProductDAO {
    private final Connection connection;

    public ProductDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    private Product map(ResultSet rs) throws SQLException {
        Product product = new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("cost_price"),
                rs.getDouble("sale_price"),
                rs.getInt("category_id"),
                rs.getInt("provider_id"),
                rs.getInt("inventory_min"),
                rs.getInt("quantity"),
                rs.getDate("create_date")
        );
        return product;
    }

    @Override
    public void create(Product product) {
        String sql = "INSERT INTO " +
                     "products (category_id, provider_id, name, inventory_min, cost_price, sale_price, description) " +
                     "VALUES (?,?,?,?,?,?,?)";

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, product.getCategory_id());
            ps.setInt(2, product.getProvider_id());
            ps.setString(3, product.getName());
            ps.setInt(4, product.getInventory_min());
            ps.setDouble(5, product.getCost_price());
            ps.setDouble(6, product.getSale_price());
            ps.setString(7, product.getDescription());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> listAll() {
        String sql = "SELECT * FROM products";
        List<Product> productList = new ArrayList<>();

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = map(rs);
                productList.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Product product = null;

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                product = map(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Integer id, String name, String description, Double cost_price, Double sale_price, Integer inventory_min) {
        String sql = "UPDATE products SET name = ?, description = ?, cost_price = ?, " +
                     "sale_price = ?, inventory_min = ? WHERE id = ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, cost_price);
            ps.setDouble(4, sale_price);
            ps.setInt(5, inventory_min);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
