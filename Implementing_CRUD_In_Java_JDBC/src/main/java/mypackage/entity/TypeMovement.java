package mypackage.entity;

public enum TypeMovement {
    IN("IN"), OUT("OUT");

    public String type_value;
    TypeMovement(String value){
        type_value = value;
    }
}
