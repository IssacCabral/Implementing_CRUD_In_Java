package mypackage.dao;

import mypackage.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    public void create(Category category);
    public List<Category> listAll();
    public Category findById(Integer id);
    public void update(Integer id, String name);
    public void delete(Integer id);
}
