package jee.projet.ecom.controller;

import jee.projet.ecom.entity.Order;
import jee.projet.ecom.entity.OrderRequest;
import jee.projet.ecom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("orders")
@CrossOrigin(origins = "http://localhost:4200")

public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("")
    public Order saveOrder(@RequestBody OrderRequest form){

        return orderService.saveOrder(form);
    }
    @GetMapping(path = "")
    public List<Order> findAllOrders() {
        return orderService.findAll();
    }
    //@PutMapping(path = "")
   /* public Order editOrder(@RequestBody OrderForm form) {

        return orderService.saveOrder(form);
    }*/


}
