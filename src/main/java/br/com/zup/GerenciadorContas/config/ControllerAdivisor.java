package br.com.zup.GerenciadorContas.config;

import br.com.zup.GerenciadorContas.exceptions.ContaNaoEncontradaException;
import br.com.zup.GerenciadorContas.exceptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdivisor {

    @ExceptionHandler(ContaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularExececaoDeContaNaoEncontrada(ContaNaoEncontradaException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(RequestException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoMaRequisicao(RequestException exception){
        return new MensagemDeErro(exception.getMessage());
    }
}
