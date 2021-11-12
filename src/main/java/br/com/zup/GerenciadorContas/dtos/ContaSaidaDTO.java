package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;
    private Status status;

}
