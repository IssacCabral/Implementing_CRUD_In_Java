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

        Product product = new Product();
        product.setName("Geladeira");
        product.setCategory_id(5);
        product.setCost_price(500);
        product.setSale_price(700);
        product.setDescription("Geladeira simples e barata");
        product.setProvider_id(2);
        product.setInventory_min(10);
        productDAO.create(product);

        productList = productDAO.listAll();
        for(Product product1 : productList){
            System.out.println(product1);
        }

    }
}
