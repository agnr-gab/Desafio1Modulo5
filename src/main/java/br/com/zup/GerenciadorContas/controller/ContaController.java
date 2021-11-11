package br.com.zup.GerenciadorContas.controller;

import br.com.zup.GerenciadorContas.dtos.AtualizarContaDTO;
import br.com.zup.GerenciadorContas.dtos.ContaDTO;
import br.com.zup.GerenciadorContas.dtos.ContaExibicaoDTO;
import br.com.zup.GerenciadorContas.model.Conta;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarConta(@RequestBody ContaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        contaService.salvarConta(conta);
    }

    @GetMapping
    public List<ContaExibicaoDTO> exibirLista() {
        List<ContaExibicaoDTO> listaExibicao = new ArrayList<>();
        for (Conta referencia : contaService.exibirTodasAsContas()) {
            ContaExibicaoDTO contaExibicaoDTO = modelMapper.map(referencia, ContaExibicaoDTO.class);
            listaExibicao.add(contaExibicaoDTO);
        }
        return listaExibicao;
    }


}
