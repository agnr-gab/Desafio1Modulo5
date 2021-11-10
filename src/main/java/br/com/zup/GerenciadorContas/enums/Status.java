package br.com.zup.GerenciadorContas.enums;

public enum Status {
    AGUARDANDO,
    PAGO,
    VENCIDA;

    private String statusConta;

    Status(String statusConta) {
        this.statusConta = statusConta;
    }

    Status() {

    }

    public String getStatusConta() {
        return statusConta;
    }
}
