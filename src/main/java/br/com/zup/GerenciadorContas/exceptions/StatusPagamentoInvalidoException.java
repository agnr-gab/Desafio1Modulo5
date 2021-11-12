package br.com.zup.GerenciadorContas.exceptions;

public class RequestException extends RuntimeException{
    public RequestException (String message){
        super(message);
    }
}
