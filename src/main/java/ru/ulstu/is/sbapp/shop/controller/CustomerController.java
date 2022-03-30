package ru.ulstu.is.sbapp.shop.controller;
import org.springframework.web.bind.annotation.*;

import ru.ulstu.is.sbapp.shop.model.Customer;
import ru.ulstu.is.sbapp.shop.model.Shop;
import ru.ulstu.is.sbapp.shop.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    /*public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.findCustomer(id);
    }

    @GetMapping("/")
    public List<Customer> getCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping("/")
    public Customer createCustomer(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("phoneNumb") int phoneNumb) {
        return customerService.addCustomer(firstName, lastName, phoneNumb);
    }

    @PatchMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("phoneNumb") int phoneNumb) {
        return customerService.updateCustomer(id, firstName, lastName, phoneNumb);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }*/
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return new CustomerDto(customerService.findCustomer(id));
    }

    @GetMapping("/")
    public List<CustomerDto> getCustomers() {
        return customerService.findAllCustomers().stream()
                .map(CustomerDto::new)
                .toList();
    }

    @PostMapping("/")
    public CustomerDto createCustomer(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                       @RequestParam("phoneNumb") int phoneNumb) {
        return new CustomerDto(customerService.addCustomer(firstName, lastName, phoneNumb));
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id,
                                    @RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                      @RequestParam("phoneNumb") int phoneNumb) {
        return new CustomerDto(customerService.updateCustomer(id, firstName, lastName, phoneNumb));
    }

    @DeleteMapping("/{id}")
    public CustomerDto deleteCustomer(@PathVariable Long id) {
        return new CustomerDto(customerService.deleteCustomer(id));
    }

    /*@GetMapping("/c{id}")
    public Shop getShop(@PathVariable Long id) {
        return customerService.findShop(id);
    }

    @GetMapping("/c")
    public List<Shop> getShops() {
        return customerService.findAllShops();
    }

    @PostMapping("/c")
    public Shop createShop(@RequestParam("NameProduct") String NameProduct,
                           @RequestParam("TypeOrder") String TypeOrder,
                           @RequestParam("cost") int cost,
                           @RequestParam("customerId") Long customerId) {
        return customerService.addShop(NameProduct, TypeOrder,  cost, customerId);
    }

    @PatchMapping("/c{id}")
    public Shop updateShop(@PathVariable Long id,
                           @RequestParam("NameProduct") String NameProduct,
                           @RequestParam("TypeOrder") String TypeOrder,
                           @RequestParam("cost") int cost,
                           @RequestParam("customerId") Long customerId) {
        return customerService.updateShop(id, NameProduct,TypeOrder, cost, customerId);
    }

   @GetMapping("/test/{id}")
    public Shop updateTestShop(@PathVariable Long id,
                               @RequestParam("NameProduct") String NameProduct,
                               @RequestParam("TypeOrder") String TypeOrder,
                               @RequestParam("cost") int cost,
                               @RequestParam("customerId") Long customerId){
        return customerService.updateShop(id, NameProduct,TypeOrder, cost, customerId);
    }

    @DeleteMapping("/c{id}")
    public Shop deleteShop(@PathVariable Long id) {
        return customerService.deleteShop(id);
    }*/
}

