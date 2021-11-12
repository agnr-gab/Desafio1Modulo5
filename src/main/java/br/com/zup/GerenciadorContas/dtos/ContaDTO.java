package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {
    @Size(min = 2, max = 20, message = "Campo obrigatório. Por favor, digite um nome entre 2 a 20 caracteres")
    private String nome;
    @NotNull(message = "Campo obrigatório. Por favor, digite o valor da conta")
    private double valor;
    @NotNull (message = "Campo obrigatório. Por favor, digite o tipo de conta")
    private Tipo tipo;
    @NotNull(message = "Campo obrigatório. Por favor, digite a data de vencimento")
    private LocalDate dataDeVencimento;
}
