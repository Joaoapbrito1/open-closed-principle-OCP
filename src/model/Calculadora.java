package model;

import java.util.HashMap;
import java.util.Map;

public class Calculadora {

    private final Map<String, Operacao> operacoes = new HashMap<>();

    public void registrarOperacao(Operacao operacao) {
        operacoes.put(operacao.getOperacao(), operacao);
    }

    public int calcular(int a, int b, String operacao) {
        Operacao op = operacoes.get(operacao);
        if (op == null) {
            throw new IllegalArgumentException("Operação não suportada: " + operacao);
        }
        return op.calcular(a, b);
    }
}