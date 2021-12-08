package mypackage.dao;

import mypackage.entity.Movement;

import java.util.List;

public interface IMovementDAO {
    public void create(Movement movement);
    public List<Movement> listAll();
    public Movement findById(Integer id);
}
