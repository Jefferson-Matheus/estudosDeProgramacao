package br.com.lettersonEnterprise.financasWEBAPP.services;

import br.com.lettersonEnterprise.financasWEBAPP.dtos.DespesaDTORecord;
import br.com.lettersonEnterprise.financasWEBAPP.dtos.DespesaDTORespostaRecord;
import br.com.lettersonEnterprise.financasWEBAPP.entities.Despesa;
import br.com.lettersonEnterprise.financasWEBAPP.repositories.DespesaRepositoryClasse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DespesaService {
    private final DespesaRepositoryClasse despesaRepositoryClasse;
    private final AtomicLong sequencia = new AtomicLong();

    public DespesaService(DespesaRepositoryClasse despesaRepositoryClasse) {
        this.despesaRepositoryClasse = despesaRepositoryClasse;
    }

    public DespesaDTORespostaRecord cadastrarDespesa(DespesaDTORecord despesa) {
        Despesa despesaEntidade = new Despesa(sequencia.incrementAndGet(), despesa.descricao(), despesa.precoDespesa());
        despesaRepositoryClasse.salvarDespesa(despesaEntidade);
        return new DespesaDTORespostaRecord(despesaEntidade.getId(), despesaEntidade.getDescricao(), despesaEntidade.getPrecoDespesa());
    }

    public List<DespesaDTORespostaRecord> listarTodasDespesar() {
        return despesaRepositoryClasse.listarTodas().stream().map(this::corverterEmDespesaDTORespostaRecord).toList();
    }

    public boolean deletarDespesa(Long id) {
        Despesa despesaEncontrada = despesaRepositoryClasse.buscarPorId(id);

        if(despesaEncontrada == null) return false;

        despesaRepositoryClasse.deletarDespesa(despesaEncontrada);
        return true;
    }


    public boolean atualizarDespesa(Long id,String descricao, double precoDescricao) {
        Despesa despesaEncontrada = despesaRepositoryClasse.buscarPorId(id);

        if(despesaEncontrada == null) return false;

        despesaRepositoryClasse.atualizarDespesa(despesaEncontrada,descricao, precoDescricao);
        return true;
    }

    public DespesaDTORespostaRecord corverterEmDespesaDTORespostaRecord(Despesa despesa) {
        return new DespesaDTORespostaRecord(despesa.getId(), despesa.getDescricao(), despesa.getPrecoDespesa());
    }
}
