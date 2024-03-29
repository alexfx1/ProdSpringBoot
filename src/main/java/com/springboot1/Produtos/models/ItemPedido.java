package com.springboot1.Produtos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ITEMPEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_pedido")
    private long id;

    @Column(name = "quantidade", nullable = false)
    private double quantidade;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "desconto", nullable = false)
    private double desconto;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produtoId")
    private Produto produto;

}
