package com.springboot1.Produtos.models;


import com.springboot1.Produtos.enums.UF;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    private long id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private int numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "estado")
    private UF estado;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    private List<Cliente> cliente(){
        return cliente();
    }

}
