package br.com.zup.GerenciadorContas.controller;

import br.com.zup.GerenciadorContas.dtos.AtualizarContaDTO;
import br.com.zup.GerenciadorContas.dtos.ContaDTO;
import br.com.zup.GerenciadorContas.dtos.ContaExibicaoDTO;
import br.com.zup.GerenciadorContas.dtos.ContaSaidaDTO;
import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.enums.Tipo;
import br.com.zup.GerenciadorContas.exceptions.StatusPagamentoInvalidoException;
import br.com.zup.GerenciadorContas.model.Conta;
import br.com.zup.GerenciadorContas.service.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
@Api(value = "Gerenciador de Contas")
@CrossOrigin(origins = "*")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastro de contas")
    public ContaSaidaDTO cadastrarConta(@RequestBody @Valid ContaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        contaService.salvarConta(conta);
        return modelMapper.map(conta, ContaSaidaDTO.class);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca por id da conta")
    public ContaSaidaDTO exibirContaID(@PathVariable int id) {
        return modelMapper.map(contaService.buscarporID(id), ContaSaidaDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "Filtro das contas utilizando parametros valor, status e tipo")
    public List<ContaExibicaoDTO> exibirListaFiltro(@RequestParam(required = false) Double valor,
                                                    @RequestParam(required = false) Status status,
                                                    @RequestParam(required = false) Tipo tipo) {
        List<ContaExibicaoDTO> listaExibicao = new ArrayList<>();
        for (Conta referencia : contaService.exibirConta(valor, status, tipo)) {
            ContaExibicaoDTO contaExibicaoDTO = modelMapper.map(referencia, ContaExibicaoDTO.class);
            listaExibicao.add(contaExibicaoDTO);
        }
        return listaExibicao;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualizar o status de pagamento")
    public ContaSaidaDTO atualizarConta(@PathVariable int id, @RequestBody AtualizarContaDTO atualizarContaDTO) {
        if (atualizarContaDTO.getStatus() == Status.PAGO) {
            ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.atualizarConta(id), ContaSaidaDTO.class);
            return contaSaidaDTO;
        }
        throw new StatusPagamentoInvalidoException("Digite um status válido");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deletar uma conta utilizando id como parametro")
    public void deletarConta(@PathVariable int id) {
        contaService.deletarConta(id);
    }

}
