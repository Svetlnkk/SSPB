package ru.ulstu.is.sbapp.shop.model;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    private String firstName;
    private String lastName;
    private int phoneNumb;
    @ManyToMany
    private List<Customer> shop;
    public Customer(){

    }
    public Customer(String firstName, String lastName, int phoneNumb) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumb=phoneNumb;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getPhoneNumb(){
        return phoneNumb;
    }
    public void setPhoneNumb(int phoneNumb){
        this.phoneNumb=phoneNumb;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
                '}';
    }
}
