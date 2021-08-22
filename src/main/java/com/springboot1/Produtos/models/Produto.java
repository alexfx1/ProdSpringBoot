package com.springboot1.Produtos.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto /*implements Serializable*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto2")
    private long id;

    //@Column(nullable = false) <---- opção para deixar nulo
    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "desconto", nullable = false)
    private double desconto;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "total", nullable = false)
    private double total;
}
