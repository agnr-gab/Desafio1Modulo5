package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarContaDTO {
    private Status status;
}
