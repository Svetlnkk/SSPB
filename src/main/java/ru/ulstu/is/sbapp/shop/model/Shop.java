package ru.ulstu.is.sbapp.shop.model;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    String NameProduct;
    String TypeOrder;
    int cost;
    Long customer_id;
    public Long getCustomer(){
        return customer_id;
    }
    public void setCustomer(Long customer_id){
        this.customer_id=customer_id;
    }
    @ManyToMany
    private List<Shop> customer;
    public Shop(){

    }
    public Shop(String TypeOrder, String NameProduct, int cost, Long customer_id){
        this.TypeOrder=TypeOrder;
        this.NameProduct=NameProduct;
        this.cost=cost;
        this.customer_id=customer_id;
    }
    public Long getId(){return id;}
    public void setId(Long id){
        this.id=id;
    }
    public String getTypeOrder(){
        return TypeOrder;
    }
    public void setTypeOrder(String typeOrder){
        this.TypeOrder=typeOrder;
    }
    public String getNameProduct(){
        return NameProduct;
    }
    public void setNameProduct(String NameProduct){
        this.NameProduct=NameProduct;
    }
    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        this.cost=cost;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(id, shop.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", nameProduct='" + NameProduct + '\'' +
                ", typeOrder='" + TypeOrder + '\'' +
                ", cost='" + cost + '\'' +
                ", customer'" + customer_id + '\'' +
                '}';
    }
}
