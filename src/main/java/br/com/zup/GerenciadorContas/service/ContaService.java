package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.model.Conta;
import br.com.zup.GerenciadorContas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta){
        conta.setDataDeVencimento(LocalDate.now());
        return contaRepository.save(conta);
    }


    /*
salvarConta()
atualizarConta()
deletarConta()
exibirConta()
exibirTodasAsContas()
     */
}
