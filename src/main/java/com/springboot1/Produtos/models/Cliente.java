package com.springboot1.Produtos.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    //@Column(nullable = false)
    private List<Pedido> pedidos;*/

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JoinColumn(name = "pedido_id")
    private List<Pedido> pedido(){
        return pedido();
    }*/

    /*@ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;*/

    /*@OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco")
    private Endereco endereco;*/
}
