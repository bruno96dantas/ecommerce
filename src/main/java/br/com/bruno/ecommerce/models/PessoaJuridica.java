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
}
