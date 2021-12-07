package mypackage.dao;

import mypackage.entity.Provider;

import java.util.List;

public interface IProviderDAO {
    public void create(Provider provider);
    public List<Provider> listAll();
    public Provider findById(Integer id);
    public void update(Integer id, String name, String cnpj);
    public void delete(Integer id);
}
