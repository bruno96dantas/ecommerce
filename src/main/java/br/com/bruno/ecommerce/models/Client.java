package br.com.bruno.ecommerce.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "clientType")
@Table
class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password; // trocar para o tipo certo

    @OneToOne
    private Cart cart;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private ClientType clientType;
}
