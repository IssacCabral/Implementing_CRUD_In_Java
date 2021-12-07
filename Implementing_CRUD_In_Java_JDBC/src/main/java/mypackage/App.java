package mypackage;

import mypackage.dao.CategoryDAOJDBC;
import mypackage.dao.ICategoryDAO;
import mypackage.database.ConnectionFactory;
import mypackage.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        Category category = new Category("celulares");
        ICategoryDAO categoryDAO = new CategoryDAOJDBC(ConnectionFactory.getConnection());
//        categoryDAO.create(category);
//        System.out.println("Ok tudo Inserido!");
        List<Category> categoryList = categoryDAO.listAll();
        for(Category category1 : categoryList){
            System.out.println(category1);
        }
    }
}
