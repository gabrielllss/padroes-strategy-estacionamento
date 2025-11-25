public class ContaEstacionamento {

    public static final long HORA = 60 * 60 * 1000; 
    public static final long DIA = 24 * HORA;
    public static final long MES = 30 * DIA;

    private Object veiculo; 
    private long inicio;
    private long fim;

    public ContaEstacionamento(Object veiculo, long inicio, long fim) {
        this.veiculo = veiculo;
        this.inicio = inicio;
        this.fim = fim;
    }

    public double valorConta() {

        long atual = (fim == 0) ? System.currentTimeMillis() : fim;
        long periodo = atual - inicio;

        if (veiculo instanceof Passeio) {

            if (periodo < 12 * HORA) {
                return 2.0 * Math.ceil((double) periodo / HORA);

            } else if (periodo <= 10 * DIA) {
                return 24.0 * Math.ceil((double) periodo / DIA);

            } else {
                return 240.0 * Math.ceil((double) periodo / MES);
            }

        } else if (veiculo instanceof Carga) {

            return 5.0 * Math.ceil((double) periodo / HORA);

        }

        return 0;
    }
}

class Passeio {}
class Carga {}
