package br.com.lettersonEnterprise.financasWEBAPP.repositories;

import br.com.lettersonEnterprise.financasWEBAPP.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
}
