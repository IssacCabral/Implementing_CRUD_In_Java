package mypackage.controller;

import mypackage.dao.CategoryDAOJDBC;
import mypackage.dao.dao_interface.ICategoryDAO;
import mypackage.entity.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryController {
    private Connection connection;
    private CategoryDAOJDBC categoryDAO;

    public CategoryController(Connection connection){
        this.connection = connection;
        categoryDAO = new CategoryDAOJDBC(this.connection);
    }

    public void create(Category category){
        this.categoryDAO.create(category);
    }

    public List<Category> listAll(){
        List<Category> categoryList = this.categoryDAO.listAll();
        return categoryList;
    }

    public Category findById(Integer id){
        Category category = this.categoryDAO.findById(id);
        return category;
    }

    public void update(Integer id, String name){
        this.categoryDAO.update(id, name);
    }

    public void delete(Integer id){
        this.categoryDAO.delete(id);
    }
}
