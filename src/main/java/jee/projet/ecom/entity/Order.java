package jee.projet.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="orders") //order mot réservé en sql
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private double totalAmount;
    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties("order")
    private Collection<OrderItem> orderItems;
}
