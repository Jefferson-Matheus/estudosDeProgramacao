package br.com.lettersonEnterprise.financasWEBAPP.repositories;


import br.com.lettersonEnterprise.financasWEBAPP.entities.Despesa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DespesaRepositoryClasse {
    private static final List<Despesa> ARMAZENAMENTO_DESPESAS = new ArrayList<>();

    public void salvarDespesa(Despesa despesa) {
        try {
            ARMAZENAMENTO_DESPESAS.add(despesa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Despesa> listarTodas() {
        List<Despesa> todasDespesas = List.copyOf(ARMAZENAMENTO_DESPESAS);

        return todasDespesas;
    }

    public Despesa buscarPorId(Long id) {
       for(Despesa despesa : ARMAZENAMENTO_DESPESAS) {
           if(despesa.getId().equals(id)) {
               return despesa;
           }
       }

       return null;
    }

    public void deletarDespesa(Despesa despesa) {
        ARMAZENAMENTO_DESPESAS.remove(despesa);
    }
    public void atualizarDespesa(Despesa despesa,String descricao,double precoDespesa) {
        despesa.setDescricao(descricao);
        despesa.setPrecoDespesa(precoDespesa);
    }
}
