package mypackage.dao;

import mypackage.dao.dao_interface.IProviderDAO;
import mypackage.entity.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProviderDAOJDBC implements IProviderDAO {
    private final Connection connection;

    public ProviderDAOJDBC(Connection connection){
        this.connection = connection;
    }

    private Provider map(ResultSet rs) throws SQLException {
        Provider provider = new Provider(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("cnpj")
        );
        return provider;
    }

    @Override
    public void create(Provider provider) {
        String sql = "INSERT INTO providers (name, cnpj) VALUES(?, ?)";
        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, provider.getName());
            ps.setString(2, provider.getCnpj());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Provider> listAll() {
        String sql = "SELECT * FROM providers";
        List<Provider> providerList = new ArrayList<>();

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Provider provider = map(rs);
                providerList.add(provider);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return providerList;
    }

    @Override
    public Provider findById(Integer id) {
        String sql = "SELECT id, name, cnpj FROM providers WHERE id = ?";
        Provider provider = null;

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                provider = map(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return provider;
    }

    @Override
    public void update(Integer id, String name, String cnpj) {
        String sql = "UPDATE providers SET name = ?, cnpj = ? WHERE id = ?";
        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, cnpj);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM providers WHERE id = ?";
        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
