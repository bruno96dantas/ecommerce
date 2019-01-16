package br.com.bruno.ecommerce.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("PF")
@Table
public class PessoaFisica extends Client {


    private String name;
    private String cpf;

    @Builder
    public PessoaFisica(Long id, String email, String password, Cart cart, Address address, String name, String cpf) {
        super(id, email, password, cart, address, ClientType.PF);
        this.name = name;
        this.cpf = cpf;
    }
}
