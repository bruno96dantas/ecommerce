package br.com.bruno.ecommerce.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("PJ")
@Table
public class PessoaJuridica extends Client {

    private String company;
    private String cnpj;

    @Builder
    public PessoaJuridica(Long id, String email, String password, Cart cart, Address address, String company, String cnpj) {
        super(id, email, password, cart, address, ClientType.PJ);
        this.company = company;
        this.cnpj = cnpj;
    }
}
