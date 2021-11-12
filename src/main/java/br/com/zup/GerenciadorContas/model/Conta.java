package br.com.zup.GerenciadorContas.model;

import br.com.zup.GerenciadorContas.enums.Status;
import br.com.zup.GerenciadorContas.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double valor;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo;
    @Column(nullable = false)
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    @Enumerated(EnumType.STRING)
    private Status status;
}
