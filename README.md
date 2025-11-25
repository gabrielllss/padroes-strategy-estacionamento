Trabalho – Engenharia de Software II
Padrões de Desenvolvimento – Padrão Strategy (GoF)

Este repositório apresenta o estudo, implementação e comparação do padrão de projeto Strategy, aplicado a um sistema simples de cálculo de tarifas de estacionamento. O objetivo é demonstrar, de forma clara e didática, como o uso desse padrão melhora a organização, flexibilidade e manutenção do código.

🚗 1. Contexto do Problema

Sistemas de cobrança de estacionamento costumam ter diferentes regras para calcular o valor final, como:

Preço por hora

Preço por diária

Preço por mensalidade

Possíveis cálculos futuros (fim de semana, noturno, eventos etc.)

No código original (sem Strategy), todas essas regras estavam concentradas dentro de um único método cheio de condicionais (IF/ELSE), tornando o sistema difícil de manter e de evoluir.

❌ 2. Antes — Código sem o padrão Strategy

O método valorConta() tentava decidir qual cálculo usar verificando o tipo do veículo:

if (veiculo instanceof Passeio) {
    ...
} else if (veiculo instanceof Carga) {
    ...
}

Problemas do código original:

Mistura regras de cálculo com lógica de negócio.

Método longo e confuso.

Difícil de testar e dar manutenção.

Para adicionar um novo cálculo, era necessário alterar o método, violando o OCP (Open/Closed Principle).

Torna o sistema rígido e frágil a mudanças.

✔️ 3. Depois — Aplicando o Padrão Strategy

O padrão Strategy permite encapsular algoritmos diferentes em classes separadas, permitindo que o cálculo seja trocado dinamicamente, sem alterar a classe principal.

🧩 Estrutura após o uso de Strategy:

Interface: CalculoValor

Estratégias:

CalculoHora

CalculoDiaria

Contexto: ContaEstacionamento

Modelo: Veiculo

Teste: Main

A classe ContaEstacionamento fica limpa:
public double valorConta(CalculoValor calculo) {
    long periodo = fim - inicio;
    return calculo.calcular(periodo);
}

E cada cálculo fica isolado:
Cálculo por Hora:
public class CalculoHora implements CalculoValor {
    @Override
    public double calcular(long periodoMillis) {
        double horas = Math.ceil(periodoMillis / HORA);
        return valorHora * horas;
    }
}

Cálculo por Diária:
public class CalculoDiaria implements CalculoValor {
    @Override
    public double calcular(long periodoMillis) {
        double dias = Math.ceil(periodoMillis / DIA);
        return valorDiaria * dias;
    }
}

🧠 4. Por que Strategy foi usado?
✔ Evita IF/ELSE enormes
✔ Facilita adicionar novos cálculos
✔ Cada regra de cálculo virou uma classe
✔ O sistema segue o Open/Closed Principle
✔ O comportamento pode ser trocado em tempo de execução
✔ A classe principal ficou limpa e fácil de manter
🧪 5. Testes — Como funciona o Main

A classe Main cria um veículo e testa duas estratégias:

Teste 1 — Cálculo por Hora
ContaEstacionamento conta1 = new ContaEstacionamento(carro, 0, seisHoras);
double valor1 = conta1.valorConta(new CalculoHora(2.0));


Período: 6 horas

Preço: R$ 2,00/hora

Resultado:

6 × 2 = R$ 12,00

Teste 2 — Cálculo por Diária
ContaEstacionamento conta2 = new ContaEstacionamento(carro, 0, umDia);
double valor2 = conta2.valorConta(new CalculoDiaria(24.0));


Período: 1 dia

Preço: R$ 24,00

Resultado:

1 × 24 = R$ 24,00

🗂 6. Estrutura do Projeto
padroes-strategy-estacionamento/
│
├── antes/
│   └── ContaEstacionamento.java
│
├── depois/
│   ├── CalculoValor.java
│   ├── CalculoHora.java
│   ├── CalculoDiaria.java
│   ├── ContaEstacionamento.java
│   ├── Main.java
│   └── models/
│       └── Veiculo.java
│
└── README.md

🔍 7. Pontos Fortes e Fracos do Padrão Strategy
Pontos Fortes

Alta flexibilidade e extensibilidade

Fácil de testar e isolar comportamentos

Reduz complexidade dentro das classes principais

Implementação simples e clara

Pontos Fracos

Cria mais classes (para cada estratégia)

Às vezes pode parecer “exagero” para regras pequenas

🏁 8. Conclusão

A aplicação do padrão Strategy tornou o sistema:

mais limpo

mais modular

mais fácil de manter

aberto para extensões

ideal para cenários onde o algoritmo muda frequentemente

O objetivo do trabalho foi atingido ao demonstrar claramente o contraste entre a abordagem tradicional (com condicionais) e o uso correto do padrão Strategy.

📚 Referência Principal

https://refactoring.guru/pt-br/design-patterns/strategy