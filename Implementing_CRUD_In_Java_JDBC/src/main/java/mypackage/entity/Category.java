package mypackage.entity;

import java.util.Date;

public class Category {
    private Integer id;
    private String name;
    private Date date_category;

    public Category(Integer id, String name, Date date_category) {
        this.id = id;
        this.name = name;
        this.date_category = date_category;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
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

    public Date getDate_category() {
        return date_category;
    }

    public void setDate_category(Date date_category) {
        this.date_category = date_category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_category=" + date_category +
                '}';
    }
}
