package br.com.senacrs;

import br.com.senacrs.models.Veiculo;

public class ContaEstacionamento {
    public static final long HORA = 60 * 60 * 1000; // ms
    public static final long DIA = 24 * HORA;
    public static final long MES = 30 * DIA;

    private Veiculo veiculo;
    private long inicio;
    private long fim;

    public ContaEstacionamento(Veiculo veiculo, long inicio, long fim){
        this.veiculo = veiculo;
        this.inicio = inicio;
        this.fim = fim;
    }

    // Recebe a estratégia de cálculo
    public double valorConta(CalculoValor calculo) {
        long atual = (fim == 0) ? System.currentTimeMillis() : fim;
        long periodo = atual - inicio;
        return calculo.calcular(periodo);
    }
}
