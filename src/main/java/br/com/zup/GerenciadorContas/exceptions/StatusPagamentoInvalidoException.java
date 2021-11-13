package br.com.zup.GerenciadorContas.exceptions;

public class StatusPagamentoInvalidoException extends RuntimeException {

    public StatusPagamentoInvalidoException(String message) {
        super(message);
    }
}
