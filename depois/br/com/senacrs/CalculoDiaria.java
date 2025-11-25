
package br.com.senacrs;

public class CalculoDiaria implements CalculoValor {

    private double valorDiaria;

    public CalculoDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public double calcular(long periodoMillis) {
        double dias = Math.ceil((double) periodoMillis / ContaEstacionamento.DIA);
        return valorDiaria * dias;
    }
}
