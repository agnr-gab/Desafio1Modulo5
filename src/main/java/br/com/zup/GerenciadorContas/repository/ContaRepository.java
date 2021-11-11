package br.com.zup.GerenciadorContas.repository;

import br.com.zup.GerenciadorContas.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository <Conta, Integer>{

}
