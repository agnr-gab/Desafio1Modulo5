package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {
    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
}
