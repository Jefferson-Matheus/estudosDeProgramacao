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

    public Despesa() {}

    public Despesa(Long id, String descricao, double precoDespesa) {
        this.id = id;
        this.descricao = descricao;
        this.precoDespesa = precoDespesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoDespesa() {
        return precoDespesa;
    }

    public void setPrecoDespesa(double precoDespesa) {
        this.precoDespesa = precoDespesa;
    }
}
