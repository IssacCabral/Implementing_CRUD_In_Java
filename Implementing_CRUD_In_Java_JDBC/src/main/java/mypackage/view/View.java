package mypackage.view;

import mypackage.controller.CategoryController;
import mypackage.controller.MovementController;
import mypackage.controller.ProductController;
import mypackage.controller.ProviderController;
import mypackage.dao.CategoryDAOJDBC;
import mypackage.dao.dao_interface.ICategoryDAO;
import mypackage.database.ConnectionFactory;
import mypackage.entity.Category;
import mypackage.entity.Movement;
import mypackage.entity.Product;
import mypackage.entity.Provider;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class View {
    private Connection connection;

    public View(Connection connection){
        this.connection = connection;
    }

    public void mainRun() throws SQLException {
        while(true){
            String op = JOptionPane.showInputDialog(Menu.MAIN_VIEW);

            if(op.equals("6")){
                break;
            }
            switch (op){
                case "1":
                    registerRun();
                    break;
                case "2":
                    consultAllRun();
                    break;
                case "3":
                    consultByIdRun();
                    break;
                case "4":
                    updateRun();
                    break;
                case "5":
                    deleteRun();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        }
    }

    private void registerRun(){
        while(true){
            String op = JOptionPane.showInputDialog(Menu.REGISTER_PANEL_VIEW);

            if(op.equals("5")){break;}
            switch (op){
                case "1":
                    CategoryController categoryController = new CategoryController(this.connection);
                    String nameCategory = JOptionPane.showInputDialog(null, "Category Name");
                    Category category = new Category(nameCategory);
                    categoryController.create(category);
                    break;


                case "2":
                    ProviderController providerController = new ProviderController(this.connection);
                    String nameProvider = JOptionPane.showInputDialog(null, "Provider Name");
                    String cnpj = JOptionPane.showInputDialog(null, "Cnpj");
                    Provider provider = new Provider(nameProvider, cnpj);
                    providerController.create(provider);
                    break;


                case "3":
                    ProductController productController = new ProductController(this.connection);
                    String nameProduct = JOptionPane.showInputDialog(null, "Product Name");
                    String description = JOptionPane.showInputDialog(null, "Description");
                    double costPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Cost Price"));
                    double salePrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Sale Price"));
                    Integer categoryId = Integer.parseInt(JOptionPane.showInputDialog(null, "Category ID"));
                    Integer providerId = Integer.parseInt(JOptionPane.showInputDialog(null, "Provider ID"));
                    Integer inventoryMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Inventory Min"));
                    Product product = new Product(nameProduct, description, costPrice, salePrice, categoryId, providerId, inventoryMin);
                    productController.create(product);
                    break;

                case "4":
                    MovementController movementController = new MovementController(this.connection);
                    Integer productId = Integer.parseInt(JOptionPane.showInputDialog(null, "Product ID"));
                    Integer quantityMovement = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity Movement"));
                    String type = JOptionPane.showInputDialog(null, "Type (IN, OUT)");
                    Movement movement = new Movement(productId, quantityMovement, type);
                    movementController.create(movement);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid INput!");
                    break;
            }
        }
    }

    private void consultAllRun() throws SQLException {

        while(true){
            String op = JOptionPane.showInputDialog(Menu.CONSULT_ALL_VIEW);

            if(op.equals("5")){break;}
            switch (op){
                case "1":
                    CategoryController categoryController = new CategoryController(this.connection);
                    String aux = "";
                    List<Category> categoryList = categoryController.listAll();
                    for(Category category : categoryList){
                        aux += category + "\n";
                    }
                    JOptionPane.showMessageDialog(null, aux);
                    break;


                case "2":
                    ProductController productController = new ProductController(this.connection);
                    aux = "";
                    List<Product> productList = productController.listAll();
                    for(Product product : productList){
                        aux += product + "\n";
                    }
                    JOptionPane.showMessageDialog(null, aux);
                    break;


                case "3":
                    ProviderController providerController = new ProviderController(this.connection);
                    aux = "";
                    List<Provider> providerList = providerController.listAll();
                    for(Provider provider : providerList){
                        aux += provider + "\n";
                    }
                    JOptionPane.showMessageDialog(null, aux);
                    break;


                case "4":
                    MovementController movementController = new MovementController(this.connection);
                    aux = "";
                    List<Movement> movementList = movementController.listAll();
                    for(Movement movement : movementList){
                        aux += movement + "\n";
                    }
                    JOptionPane.showMessageDialog(null, aux);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                    break;
            }
        }
    }

    private void consultByIdRun(){
        while(true){
            String op = JOptionPane.showInputDialog(Menu.CONSULT_BY_ID_VIEW);

            if(op.equals("5")){break;};
            switch (op){
                case "1":
                    CategoryController categoryController = new CategoryController(this.connection);
                    Integer idCategory = Integer.parseInt(JOptionPane.showInputDialog(null, "Category ID"));
                    Category category = categoryController.findById(idCategory);
                    if(category != null){
                        JOptionPane.showMessageDialog(null, category);
                    }else{
                        JOptionPane.showMessageDialog(null, "Category Not Found!");
                    }
                    break;


                case "2":
                    ProviderController providerController = new ProviderController(this.connection);
                    Integer idprovider = Integer.parseInt(JOptionPane.showInputDialog(null, "Provider ID"));
                    Provider provider = providerController.findById(idprovider);
                    if(provider != null){
                        JOptionPane.showMessageDialog(null, provider);
                    }else{
                        JOptionPane.showMessageDialog(null, "Provider Not Found");
                    }
                    break;


                case "3":
                    ProductController productController = new ProductController(this.connection);
                    Integer idProduct = Integer.parseInt(JOptionPane.showInputDialog(null, "Product ID"));
                    Product product = productController.findById(idProduct);
                    if(product != null){
                        JOptionPane.showMessageDialog(null, product);
                    }else{
                        JOptionPane.showMessageDialog(null, "Product Not Found");
                    }
                    break;


                case "4":
                    MovementController movementController = new MovementController(this.connection);
                    Integer idMovement = Integer.parseInt(JOptionPane.showInputDialog(null, "Movement ID"));
                    Movement movement = movementController.findById(idMovement);
                    if(movement != null){
                        JOptionPane.showMessageDialog(null, movement);
                    }else{
                        JOptionPane.showMessageDialog(null, "Movement Not Found");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                    break;
            }
        }
    }

    private void updateRun(){
        while(true){
            String op = JOptionPane.showInputDialog(Menu.UPDATE_VIEW);

            if(op.equals("4")){break;}
            switch (op){
                case "1":
                    CategoryController categoryController = new CategoryController(this.connection);
                    Integer idCategory = Integer.parseInt(JOptionPane.showInputDialog(null, "Category ID"));
                    Category category = categoryController.findById(idCategory);
                    if(category != null){
                        String categoryName = JOptionPane.showInputDialog(null, "Category name");
                        categoryController.update(idCategory, categoryName);
                    }else{
                        JOptionPane.showMessageDialog(null, "Category Not Found to Update!");
                    }
                    break;


                case "2":
                    ProviderController providerController = new ProviderController(this.connection);
                    Integer idProvider = Integer.parseInt(JOptionPane.showInputDialog(null, "Provider ID"));
                    Provider provider = providerController.findById(idProvider);
                    if(provider != null){
                        String nameProvider = JOptionPane.showInputDialog(null, "Provider Name");
                        String cnpj = JOptionPane.showInputDialog(null, "cnpj");
                        providerController.update(idProvider, nameProvider, cnpj);
                    }else{
                        JOptionPane.showMessageDialog(null, "Provider Not Found to Update");
                    }
                    break;


                case "3":
                    ProductController productController = new ProductController(this.connection);
                    Integer idProduct = Integer.parseInt(JOptionPane.showInputDialog(null, "Product ID"));
                    Product product = productController.findById(idProduct);
                    if(product != null){
                        String productName = JOptionPane.showInputDialog(null, "Product Name");
                        String description = JOptionPane.showInputDialog(null, "Description");
                        Double cost_price = Double.parseDouble
                                (JOptionPane.showInputDialog(null, "Cost Price"));
                        Double sale_price = Double.parseDouble
                                (JOptionPane.showInputDialog(null, "Sale Price"));
                        Integer inventory_Min = Integer.parseInt
                                (JOptionPane.showInputDialog(null, "Inventory Min"));

                        productController.update(idProduct, productName, description, cost_price, sale_price, inventory_Min);
                    }else{
                        JOptionPane.showMessageDialog(null, "Product Not Found to Update!");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                    break;
            }
        }
    }

    private void deleteRun(){
        while(true){
            String op = JOptionPane.showInputDialog(Menu.DELETE_VIEW);

            if(op.equals("4")){break;}
            switch (op){
                case "1":
                    CategoryController categoryController = new CategoryController(this.connection);
                    Integer categoryId = Integer.parseInt
                            (JOptionPane.showInputDialog(null, "Category ID"));
                    Category category = categoryController.findById(categoryId);
                    if(category != null){
                        categoryController.delete(categoryId);
                    }else{
                        JOptionPane.showMessageDialog(null, "Category Not Found to Delete");
                    }
                    break;


                case "2":
                    ProviderController providerController = new ProviderController(this.connection);
                    Integer providerId = Integer.parseInt
                            (JOptionPane.showInputDialog(null, "Provider ID"));
                    Provider provider = providerController.findById(providerId);
                    if(provider != null){
                        providerController.delete(providerId);
                    }else{
                        JOptionPane.showMessageDialog(null, "Provider Not Found to Delete");
                    }
                    break;


                case "3":
                    ProductController productController = new ProductController(this.connection);
                    Integer productId = Integer.parseInt
                            (JOptionPane.showInputDialog(null, "Product ID"));
                    Product product = productController.findById(productId);
                    if(product != null){
                        productController.delete(productId);
                    }else{
                        JOptionPane.showMessageDialog(null, "Product Not Found to Delete");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                    break;
            }
        }
    }
}
