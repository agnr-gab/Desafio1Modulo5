package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.dtos.ContaDTO;
import br.com.zup.GerenciadorContas.dtos.ContaSaidaDTO;
import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.model.Conta;
import br.com.zup.GerenciadorContas.repository.ContaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Conta salvarConta(Conta conta) {
        conta.setDataDeVencimento(LocalDate.now());
        return contaRepository.save(conta);
    }

    public void verificarStatus(ContaDTO contaDTO, ContaSaidaDTO contaSaidaDTO) {
        if (contaDTO.getDataDeVencimento().isBefore(LocalDate.now())) {
            contaSaidaDTO.setStatus(Status.VENCIDA);
        } else {
            contaSaidaDTO.setStatus(Status.AGUARDANDO);
        }
    }

    public List<Conta> exibirTodasAsContas(Integer id, String nome, Double valor, Status status) {
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
    /*public Conta atualizarConta(){

    }
    public Conta atualizarConta(){}
    public Conta deletarConta(){}
    public Conta exibirConta(int id){}
    public List<Conta> exibirTodasAsContas(){

    salvarConta()
atualizarConta()
deletarConta()
exibirConta()
exibirTodasAsContas()


     */
}
