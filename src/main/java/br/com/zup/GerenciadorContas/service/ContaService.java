package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.exceptions.ContaNaoEncontradaException;
import br.com.zup.GerenciadorContas.model.Conta;
import br.com.zup.GerenciadorContas.repository.ContaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Conta salvarConta(Conta conta) {
        LocalDate dataHoje = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(dataHoje)) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }return contaRepository.save(conta);
    }

    public Conta atualizarConta(int id){
        Conta conta = buscarporID(id);
        conta.setStatus(Status.PAGO);
        conta.setDataDePagamento(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }

    public Conta buscarporID (int id) {
        Optional<Conta> byId = contaRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ContaNaoEncontradaException("Não encontrado");
        }
        return byId.get();
    }

    public List<Conta> exibirTodasAsContas() {
        List<Conta> listaDeTodasAsContas = (List<Conta>) contaRepository.findAll();
        return listaDeTodasAsContas;
    }

    public List<Conta> exibirConta(Integer id, String nome, Double valor, Status status) {
        if (id != null) {
            contaRepository.findAllById(id);
        } else if (nome != null) {
            contaRepository.findAllByNome(nome);
        } else if (valor != null) {
            contaRepository.findAllByValor(valor);
        } else if (status != null) {
            contaRepository.findAllByStatus(status);
        }
        List<Conta> listaDeContas = (List<Conta>) contaRepository.findAll();
        return listaDeContas;
    }
    /*
    public Conta atualizarConta(){} ok
    public Conta deletarConta(){}
    public Conta exibirConta(int id){} ok
    public List<Conta> exibirTodasAsContas(){

    salvarConta()
atualizarConta()
deletarConta()
exibirConta()
exibirTodasAsContas()


     */
}
