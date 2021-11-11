package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaExibicaoDTO {
    private int id;
    private String nome;
    private double valor;
    private Status status;

}
