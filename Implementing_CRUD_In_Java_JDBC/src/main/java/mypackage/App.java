package mypackage;

import mypackage.dao.*;
import mypackage.dao.dao_interface.IProductDAO;
import mypackage.database.ConnectionFactory;
import mypackage.entity.Product;
import mypackage.view.Menu;
import mypackage.view.View;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        View view = new View(ConnectionFactory.getConnection());
        view.mainRun();

    }
}
