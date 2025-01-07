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
