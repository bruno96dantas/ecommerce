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
}
