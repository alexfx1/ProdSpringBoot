package com.springboot1.Produtos.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor",nullable = false)
    private BigDecimal valor;

    @Column(name = "desconto", nullable = false)
    private BigDecimal desconto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtoId")
    private Produto produto;

}
