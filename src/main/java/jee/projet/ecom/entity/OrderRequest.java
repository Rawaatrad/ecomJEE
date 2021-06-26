package jee.projet.ecom.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequest {
    private List<Product> products =new ArrayList<>();

}


