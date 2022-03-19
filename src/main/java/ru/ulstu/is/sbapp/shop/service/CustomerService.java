package ru.ulstu.is.sbapp.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ru.ulstu.is.sbapp.shop.model.Customer;
import ru.ulstu.is.sbapp.shop.model.Shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CustomerService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Customer addCustomer(String firstName, String lastName, int phoneNumb) {
        if (!StringUtils.hasText(firstName) || !StringUtils.hasText(lastName) || !StringUtils.hasText(Integer.toString(phoneNumb))) {
            throw new IllegalArgumentException("Customer name is null or empty");
        }
        final Customer customer = new Customer(firstName, lastName, phoneNumb);
        em.persist(customer);
        return customer;
    }

    @Transactional(readOnly = true)
    public Customer findCustomer(Long id) {
        final Customer customer = em.find(Customer.class, id);
        if (customer == null) {
            throw new EntityNotFoundException(String.format("Customer with id [%s] is not found", id));
        }
        return customer;
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllCustomers() {
        return em.createQuery("select s from Customer s", Customer.class)
                .getResultList();
    }

    @Transactional
    public Customer updateCustomer(Long id, String firstName, String lastName, int phoneNumb) {
        if (!StringUtils.hasText(firstName) || !StringUtils.hasText(lastName) || !StringUtils.hasText(Integer.toString(phoneNumb))) {
            throw new IllegalArgumentException("Customer name is null or empty");
        }
        final Customer currentCustomer = findCustomer(id);
        currentCustomer.setFirstName(firstName);
        currentCustomer.setLastName(lastName);
        currentCustomer.setPhoneNumb(phoneNumb);
        return em.merge(currentCustomer);
    }

    @Transactional
    public Customer deleteCustomer(Long id) {
        final Customer currentCustomer = findCustomer(id);
        em.remove(currentCustomer);
        return currentCustomer;
    }

    @Transactional
    public void deleteAllCustomers() {
        em.createQuery("delete from Customer").executeUpdate();
    }

    @Transactional
    public Shop addShop(String NameProduct, String TypeOrder, int cost, Long customer) {
        if (!StringUtils.hasText(TypeOrder) || !StringUtils.hasText(NameProduct) || !StringUtils.hasText(Integer.toString(cost))) {
            throw new IllegalArgumentException("Shop name is null or empty");
        }
        final Shop shop = new Shop( NameProduct,TypeOrder, cost, customer);
        em.persist(shop);
        return shop;
    }

    @Transactional(readOnly = true)
    public Shop findShop(Long id) {
        final Shop shop = em.find(Shop.class, id);
        if (shop == null) {
            throw new EntityNotFoundException(String.format("Shop with id [%s] is not found", id));
        }
        return shop;
    }

    @Transactional(readOnly = true)
    public List<Shop> findAllShops() {
        return em.createQuery("select s from Shop s", Shop.class)
                .getResultList();
    }

    @Transactional
    public Shop updateShop(Long id,  String NameProduct,String TypeOrder, int cost, Long customer) {
        if (!StringUtils.hasText(TypeOrder) || !StringUtils.hasText(NameProduct) || !StringUtils.hasText(Integer.toString(cost))) {
            throw new IllegalArgumentException("Shop name is null or empty");
        }
        final Shop currentShop = findShop(id);
        currentShop.setNameProduct(NameProduct);
        currentShop.setTypeOrder(TypeOrder);
        currentShop.setCost(cost);
        currentShop.setCustomer(customer);
        return em.merge(currentShop);
    }

    @Transactional
    public Shop deleteShop(Long id) {
        final Shop currentShop = findShop(id);
        em.remove(currentShop);
        return currentShop;
    }

    @Transactional
    public void deleteAllShops() {
        em.createQuery("delete from Shop").executeUpdate();
    }
}
