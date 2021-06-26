package jee.projet.ecom.service;


import jee.projet.ecom.Repository.OrderItemRepository;
import jee.projet.ecom.Repository.OrderRepository;
import jee.projet.ecom.Repository.ProductRepository;
import jee.projet.ecom.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepo;

    public Order saveOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setStatus("sent");
        order= orderRepository.save(order);
        double totalAmount=0;
        for(Product product: orderRequest.getProducts()){
            totalAmount+=product.getPrice();
            OrderItem orderItem=new OrderItem();
            orderItem.setOrder(order);

            orderItem.setProduct(product);
            orderItem.setQuantity(1);
            orderItemRepo.save(orderItem);
        }
        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);

    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }



}
