package mypackage.dao.dao_interface;

import mypackage.entity.Product;

import java.util.List;

public interface IProductDAO {
    public void create(Product product);
    public List<Product> listAll();
    public Product findById(Integer id);
    public void update(
            Integer id,
            String name,
            String description,
            Double cost_price,
            Double sale_price,
            Integer inventory_min);
    public void delete(Integer id);
}
