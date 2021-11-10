package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaSaidaDTO {
    private int id;
    private String nome;
    private Tipo tipo;
    private LocalDateTime dataDeVencimento;
    private LocalDate dataDePagamento;
    private Status status;

}
