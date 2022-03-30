package ru.ulstu.is.sbapp.shop.controller;
import ru.ulstu.is.sbapp.shop.model.Customer;
import ru.ulstu.is.sbapp.shop.model.Shop;
public class ShopDto {
    private final long id;
    private final String name;
    private final int cost;
    private final long customer_id;

    public ShopDto(Shop shop) {
        this.id = shop.getId();
        this.name = String.format("%s %s", shop.getNameProduct(), shop.getTypeOrder());
        this.cost= shop.getCost();
        this.customer_id=shop.getCustomer();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getCost(){return cost;}
    public long getCustomer_id(){return customer_id;}
}
