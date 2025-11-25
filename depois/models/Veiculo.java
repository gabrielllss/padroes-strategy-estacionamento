package br.com.senacrs.models;

public class Veiculo {
    private String tipo; // "passeio", "carga", etc

    public Veiculo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
