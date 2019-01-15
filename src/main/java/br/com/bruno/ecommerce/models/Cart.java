package br.com.bruno.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_client")
    private Client client;

    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = { @JoinColumn(name = "fk_cart")},
            inverseJoinColumns = { @JoinColumn(name = "fk_product") })
    private Set<Product> productList;
}
