package br.com.senacrs;

public class CalculoHora implements CalculoValor {
    private double valorHora;

    public CalculoHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcular(long periodoMillis) {
        double horas = Math.ceil((double) periodoMillis / ContaEstacionamento.HORA);
        return valorHora * horas;
    }
}
