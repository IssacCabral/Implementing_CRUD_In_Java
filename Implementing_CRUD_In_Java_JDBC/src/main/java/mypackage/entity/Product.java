package mypackage.entity;

import java.util.Date;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private double cost_price;
    private double sale_price;
    private Integer category_id;
    private Integer provider_id;
    private Integer inventory_min;
    private Integer quantity;
    private Date createDate;

    public Product(
            Integer id, String name, String description,
            double cost_price, double sale_price, Integer category_id,
            Integer provider_id, Integer inventory_min
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost_price = cost_price;
        this.sale_price = sale_price;
        this.category_id = category_id;
        this.provider_id = provider_id;
        this.inventory_min = inventory_min;
    }

    public Product(Integer id, String name, String description, double cost_price,
                   double sale_price, Integer category_id, Integer provider_id, Integer
                   inventory_min, Integer quantity, Date createDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost_price = cost_price;
        this.sale_price = sale_price;
        this.category_id = category_id;
        this.provider_id = provider_id;
        this.inventory_min = inventory_min;
        this.quantity = quantity;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost_price() {
        return cost_price;
    }

    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Integer provider_id) {
        this.provider_id = provider_id;
    }

    public Integer getInventory_min() {
        return inventory_min;
    }

    public void setInventory_min(Integer inventory_min) {
        this.inventory_min = inventory_min;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost_price=" + cost_price +
                ", sale_price=" + sale_price +
                ", category_id=" + category_id +
                ", provider_id=" + provider_id +
                ", inventory_min=" + inventory_min +
                ", quantity=" + quantity +
                ", createDate=" + createDate +
                '}';
    }
}
