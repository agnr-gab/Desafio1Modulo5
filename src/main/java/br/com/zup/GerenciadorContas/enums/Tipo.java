package br.com.zup.GerenciadorContas.enums;

public enum Tipo {
    LUZ,
    AGUA,
    COMIDA,
    LAZER,
    OUTROS;

    private String tipoConta;

    Tipo() {
    }

    Tipo(String tipoConta) {

        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}