package br.com.bruno.ecommerce.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "clientType")
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password; // trocar para o tipo certo

    @OneToOne
    private Cart cart;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private ClientType clientType;
}
