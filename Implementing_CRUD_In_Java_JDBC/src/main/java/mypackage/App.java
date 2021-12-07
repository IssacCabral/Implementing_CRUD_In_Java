package mypackage;

import mypackage.dao.*;
import mypackage.database.ConnectionFactory;
import mypackage.entity.Category;
import mypackage.entity.Product;
import mypackage.entity.Provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        IProductDAO productDAO = new ProductDAOJDBC(ConnectionFactory.getConnection());
        List<Product> productList = productDAO.listAll();
        for(Product product : productList){
            System.out.println(product);
        }

    }
}
