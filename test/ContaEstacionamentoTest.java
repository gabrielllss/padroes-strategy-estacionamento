import org.junit.Assert;
import org.junit.Test;
import br.com.senacrs.*;
import br.com.senacrs.models.Veiculo;

public class ContaEstacionamentoTest {

    @Test
    public void calculaValorHora() {
        Veiculo v = new Veiculo("passeio");
        long inicio = System.currentTimeMillis() - 2 * ContaEstacionamento.HORA;
        ContaEstacionamento conta = new ContaEstacionamento(v, inicio, System.currentTimeMillis());
        CalculoValor calcHora = new CalculoHora(2.0);

        double resultado = conta.valorConta(calcHora);
        Assert.assertEquals(4.0, resultado, 0.001);
    }

    @Test
    public void calculaValorDiaria() {
        Veiculo v = new Veiculo("passeio");
        long inicio = System.currentTimeMillis() - 13 * ContaEstacionamento.HORA;
        ContaEstacionamento conta = new ContaEstacionamento(v, inicio, System.currentTimeMillis());
        CalculoValor calcDiaria = new CalculoDiaria(24.0);

        double resultado = conta.valorConta(calcDiaria);
        Assert.assertEquals(24.0, resultado, 0.001);
    }
}
