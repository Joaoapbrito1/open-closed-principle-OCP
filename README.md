# Exercícios para praticar SOLID!

## Exercício 2: Open/Closed Principle (OCP)

### Enunciado:
Você está desenvolvendo uma calculadora para o banco que realiza operações básicas como soma e subtração. No entanto, o gerente pediu para adicionar uma nova operação: multiplicação. Refatore o código para que ele siga o Princípio Aberto/Fechado (OCP), permitindo adicionar novas operações sem modificar o código existente.

Código inicial (errado):
```java
public class Calculadora {
    public int calcular(int a, int b, String operacao) {
        if (operacao.equals("soma")) {
            return a + b;
        } else if (operacao.equals("subtracao")) {
            return a - b;
        }
        return 0;
    }
}
```

### Tarefa:
- Crie uma interface Operacao.
- Implemente classes separadas para cada operação (Soma, Subtração, Multiplicação).
- Refatore a classe Calculadora para usar a interface.

## Resolução 
A solução refatorada segue o Princípio Aberto/Fechado (OCP), que indica que o código deve estar aberto para extensão, mas fechado para modificação.

- Interface Operacao

```java
package model;

public interface Operacao {
    int calcular( int a, int b);
    String getOperacao();
}
```
Define o contrato para todas as operações, garantindo que cada operação tenha o método calcular e o identificador getOperacao.

- Classes específicas para cada operação

```java
package service;

import model.Operacao;

public class Multiplicacao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a * b;
    }

    @Override
    public String getOperacao() {
        return "Multiplicacao";
    }
}
```
```java
package service;

import model.Operacao;

public class Soma implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a + b;
    }

    @Override
    public String getOperacao() {
        return "Soma";
    }
}
```
```java
package service;

import model.Operacao;

public class Subtracao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a - b;
    }

    @Override
    public String getOperacao() {
        return "Subtracao";
    }
}
```
Cada operação (soma, subtração e multiplicação) foi implementada em sua própria classe, seguindo a interface. Isso garante independência e facilita a adição de novas operações.

- Classe Calculadora

```java
package model;

import java.util.HashMap;
import java.util.Map;

public class Calculadora {

    private final Map<String, Operacao> operacoes = new HashMap<>();

    public void registrarOperacao(Operacao operacao) {
        operacoes.put(operacao.getOperacao(), operacao);
    }

    public int calcular(int a, int b, String operacao) throws IllegalArgumentException {
        Operacao op = operacoes.get(operacao);
        if (op == null) {
            throw new IllegalArgumentException("Operação não suportada: " + operacao);
        }
        return op.calcular(a, b);
    }
}
```
O código principal da calculadora não precisa ser alterado para suportar novas operações. Basta criar uma nova classe que implemente Operacao e registrá-la no mapa.

## Conclusão
Dessa forma melhora a organização, modularidade e manutenção do código, facilitando futuras expansões.

