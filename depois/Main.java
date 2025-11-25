package br.com.senacrs;

import br.com.senacrs.models.Veiculo;

public class Main {

    public static void main(String[] args) {

        // Criando veículo
        Veiculo veiculo = new Veiculo("passeio");

        // Simulando permanência de 3 horas
        long inicio = System.currentTimeMillis() - (3 * ContaEstacionamento.HORA);
        long fim = System.currentTimeMillis();

        ContaEstacionamento conta = new ContaEstacionamento(veiculo, inicio, fim);

        // Estratégias de cálculo
        CalculoValor calcHora = new CalculoHora(2.0);     // R$2 por hora
        CalculoValor calcDiaria = new CalculoDiaria(24.0); // R$24 a diária

        System.out.println("=== Demonstração Strategy ===");
        System.out.println("Tempo simulado: 3 horas\n");

        System.out.println("Cálculo por hora: R$ " + conta.valorConta(calcHora));
        System.out.println("Cálculo por diária: R$ " + conta.valorConta(calcDiaria));
    }
}
