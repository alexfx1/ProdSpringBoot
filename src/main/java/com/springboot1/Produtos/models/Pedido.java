package com.springboot1.Produtos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "desconto", nullable = false)
    private double desconto;

    @Column(name = "frete", nullable = false)
    private double frete;

    @Column(name = "valorTotal")
    private double valorTotal;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "pedidoId", nullable = false)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
    private List<ItemPedido> itens(){
        return itens();
    }
}
