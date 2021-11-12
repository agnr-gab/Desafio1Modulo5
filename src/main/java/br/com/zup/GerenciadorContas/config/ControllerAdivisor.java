package br.com.zup.GerenciadorContas.config;

import br.com.zup.GerenciadorContas.exceptions.ContaNaoEncontradaException;
import br.com.zup.GerenciadorContas.exceptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdivisor {

    @ExceptionHandler(ContaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularExececaoDeContaNaoEncontrada(ContaNaoEncontradaException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(RequestException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoMaRequisicao(RequestException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularErrosDeSintaxe(MethodArgumentNotValidException exception) {
        List<MensagemDeErro> listaDeErros = new ArrayList<>();
        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemDeErro mensagemDeErro = new MensagemDeErro(fieldError.getDefaultMessage());
            listaDeErros.add(mensagemDeErro);
        }
        return listaDeErros;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularErrosJson(HttpMessageNotReadableException exception){
        return new MensagemDeErro("Dado inserido incorretamente. Verifique!");
    }
}
