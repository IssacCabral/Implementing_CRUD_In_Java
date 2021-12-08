package mypackage.entity;


import java.util.Date;

public class Movement {
    private Integer id;
    private Integer productId;
    private Integer quantity_movement;
    private TypeMovement type;
    private String typeMovementString;
    private double price;
    private Date dateMovement;

    public Movement(Integer id, Integer productId, Integer quantity_movement, TypeMovement type, double price, Date dateMovement) {
        this.id = id;
        this.productId = productId;
        this.quantity_movement = quantity_movement;
        this.type = type;
        this.price = price;
        this.dateMovement = dateMovement;
    }

    public Movement(Integer id, Integer productId, Integer quantity_movement, String typeMovementString, double price, Date dateMovement) {
        this.id = id;
        this.productId = productId;
        this.quantity_movement = quantity_movement;
        this.typeMovementString = typeMovementString;
        this.price = price;
        this.dateMovement = dateMovement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getTypeMovementString() {
        return typeMovementString;
    }

    public void setTypeMovementString(String typeMovementString) {
        this.typeMovementString = typeMovementString;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity_movement() {
        return quantity_movement;
    }

    public void setQuantity_movement(Integer quantity_movement) {
        this.quantity_movement = quantity_movement;
    }

    public TypeMovement getType() {
        return type;
    }

    public void setType(TypeMovement type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(Date dateMovement) {
        this.dateMovement = dateMovement;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity_movement=" + quantity_movement +
                ", type=" + type +
                ", price=" + price +
                ", dateMovement=" + dateMovement +
                '}';
    }
}
