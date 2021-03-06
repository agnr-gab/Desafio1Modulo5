package br.com.zup.GerenciadorContas.repository;

import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.enums.Tipo;
import br.com.zup.GerenciadorContas.model.Conta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {

    List<Conta> findAllById(int id);

    List<Conta> findAllByNome(String nome);

    List<Conta> findAllByStatus(Status status);

    List<Conta> findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM contas WHERE valor BETWEEN :valor-10 AND :valor+10", nativeQuery = true)
    List<Conta> findAllByValor(double valor);

}
