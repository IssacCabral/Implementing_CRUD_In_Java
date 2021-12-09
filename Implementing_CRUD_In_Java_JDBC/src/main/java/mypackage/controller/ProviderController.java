package mypackage.controller;

import mypackage.dao.ProviderDAOJDBC;
import mypackage.entity.Provider;

import java.sql.Connection;
import java.util.List;

public class ProviderController {
    private Connection connection;
    private ProviderDAOJDBC providerDAOJDBC;

    public ProviderController(Connection connection){
        this.connection = connection;
        providerDAOJDBC = new ProviderDAOJDBC(this.connection);
    }

    public void create(Provider provider){
        this.providerDAOJDBC.create(provider);
    }

    public List<Provider> listAll(){
        List<Provider> providerList = this.providerDAOJDBC.listAll();
        return providerList;
    }

    public Provider findById(Integer id){
        Provider provider = this.providerDAOJDBC.findById(id);
        return provider;
    }

    public void update(Integer id, String name, String cnpj){
        this.providerDAOJDBC.update(id, name, cnpj);
    }

    public void delete(Integer id){
        this.providerDAOJDBC.delete(id);
    }
}
