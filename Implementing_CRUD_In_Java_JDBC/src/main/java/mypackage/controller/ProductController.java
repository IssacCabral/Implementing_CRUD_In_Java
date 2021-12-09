package mypackage.controller;

import mypackage.dao.ProductDAOJDBC;
import mypackage.entity.Product;

import java.sql.Connection;
import java.util.List;

public class ProductController {
    private Connection connection;
    private ProductDAOJDBC productDAOJDBC;

    public ProductController(Connection connection){
        this.connection = connection;
        this.productDAOJDBC = new ProductDAOJDBC(this.connection);
    }

    public void create(Product product){
        this.productDAOJDBC.create(product);
    }

    public List<Product> listAll(){
        List<Product> productList = this.productDAOJDBC.listAll();
        return productList;
    }

    public Product findById(Integer id){
        Product product = this.productDAOJDBC.findById(id);
        return product;
    }

    public void update(Integer id, String name, String description, Double cost_price, Double sale_price, Integer inventory_min){
        this.productDAOJDBC.update(id, name, description, cost_price, sale_price, inventory_min);
    }

    public void delete(Integer id){
        this.productDAOJDBC.delete(id);
    }
}
