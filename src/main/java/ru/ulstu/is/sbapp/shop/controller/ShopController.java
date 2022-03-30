package ru.ulstu.is.sbapp.shop.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.sbapp.shop.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final CustomerService customerService;
    public ShopController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ShopDto getShop(@PathVariable Long id) {
        return new ShopDto(customerService.findShop(id));
    }

    @GetMapping("/")
    public List<ShopDto> getShops() {
        return customerService.findAllShops().stream()
                .map(ShopDto::new)
                .toList();
    }

    @PostMapping("/")
    public ShopDto createShop(@RequestParam("nameProduct") String NameProduct,
                                      @RequestParam("typeOrder") String TypeOrder,
                                      @RequestParam("cost") int cost,
                              @RequestParam("customer_id") long customer_id){
        return new ShopDto(customerService.addShop(NameProduct, TypeOrder, cost, customer_id));
    }

    @PutMapping("/{id}")
    public ShopDto updateShop(@PathVariable Long id,
                              @RequestParam("nameProduct") String NameProduct,
                              @RequestParam("typeOrder") String TypeOrder,
                              @RequestParam("cost") int cost,
                              @RequestParam("customer_id") long customer_id) {
        return new ShopDto(customerService.updateShop(id, NameProduct, TypeOrder, cost, customer_id));
    }

    @DeleteMapping("/{id}")
    public ShopDto deleteShop(@PathVariable Long id) {
        return new ShopDto(customerService.deleteShop(id));
    }

}
