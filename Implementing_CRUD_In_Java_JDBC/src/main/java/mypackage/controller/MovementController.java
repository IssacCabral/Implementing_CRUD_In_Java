package mypackage.controller;

import mypackage.dao.MovementDAOJDBC;
import mypackage.entity.Movement;

import java.sql.Connection;
import java.util.List;

public class MovementController {
    private Connection connection;
    private MovementDAOJDBC movementDAOJDBC;

    public MovementController(Connection connection){
        this.connection = connection;
        movementDAOJDBC = new MovementDAOJDBC(this.connection);
    }

    public void create(Movement movement){
        this.movementDAOJDBC.create(movement);
    }

    public List<Movement> listAll(){
        List<Movement> movementList = this.movementDAOJDBC.listAll();
        return movementList;
    }

    public Movement findById(Integer id){
        Movement movement = this.movementDAOJDBC.findById(id);
        return movement;
    }
}
