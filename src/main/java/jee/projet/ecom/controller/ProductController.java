package jee.projet.ecom.controller;

import javassist.NotFoundException;
import jee.projet.ecom.entity.Product;
import jee.projet.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping(path = "product")
    public List<Product> findAllProduct() {
        return productService.findAll();
    }

    @ExceptionHandler(Exception.class)
    @GetMapping(path = "product/{id}")
    public Optional<Product> findProduitById(@PathVariable long id) throws NotFoundException {
        Optional<Product> product = productService.findById(id);

        if (product.isPresent() == false) {
            throw new NotFoundException("Entity with id = " + id + "NOT FOUND");
        }

        return productService.findById(id);
    }

}
