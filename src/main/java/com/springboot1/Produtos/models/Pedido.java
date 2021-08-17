package com.springboot1.Produtos.models;

import com.springboot1.Produtos.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private long id;

    @Column(name = "Status")
    private Status status;

    // chave estrangeira
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "desconto", nullable = false)
    private BigDecimal desconto;

    @Column(name = "frete", nullable = false)
    private BigDecimal frete;

    /*@OneToOne
    @JoinColumn(name = "itemPedido", referencedColumnName = "id", nullable = false)
    private ItemPedido itemPedidoId;*/

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedido> listaItemPedido(){
        return listaItemPedido();
    };
}
