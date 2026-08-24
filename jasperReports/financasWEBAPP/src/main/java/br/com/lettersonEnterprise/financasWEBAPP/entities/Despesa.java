package br.com.lettersonEnterprise.financasWEBAPP.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private double precoDespesa;
}
