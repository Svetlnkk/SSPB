package ru.ulstu.is.sbapp.shop.controller;
import ru.ulstu.is.sbapp.shop.model.Customer;
public class CustomerDto {
    private final long id;
    private final String name;
    private final int phoneNumb;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = String.format("%s %s", customer.getFirstName(), customer.getLastName());
        this.phoneNumb= customer.getPhoneNumb();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getPhoneNumb(){return phoneNumb;}
}
