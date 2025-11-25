
package br.com.senacrs;

import br.com.senacrs.models.Veiculo;

public class Main {

    public static void main(String[] args) {

        Veiculo carro = new Veiculo("ABC-1234");

        long umaHora = 1 * 60 * 60 * 1000;
        long seisHoras = 6 * umaHora;
        long umDia = 24 * umaHora;

        System.out.println("=== TESTES DO PADRÃO STRATEGY ===\n");

        System.out.println("-> Usando estratégia: CalculoHora");

        ContaEstacionamento conta1 = new ContaEstacionamento(carro, 0, seisHoras);
        double valor1 = conta1.valorConta(new CalculoHora(2.0));
        System.out.println("6 horas = R$ " + valor1);

        System.out.println("\n-> Usando estratégia: CalculoDiaria");

        ContaEstacionamento conta2 = new ContaEstacionamento(carro, 0, umDia);
        double valor2 = conta2.valorConta(new CalculoDiaria(24.0));
        System.out.println("1 dia = R$ " + valor2);

      
    }
}

