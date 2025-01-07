package main;

import model.Calculadora;
import service.Multiplicacao;
import service.Soma;
import service.Subtracao;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Registrando operações
        calculadora.registrarOperacao(new Soma());
        calculadora.registrarOperacao(new Subtracao());
        calculadora.registrarOperacao(new Multiplicacao());

        // Testando operações
        System.out.println("Soma: " + calculadora.calcular(2,4,"Soma"));
        System.out.println("Subtração: " + calculadora.calcular(5, 3, "Subtracao"));
        System.out.println("Multiplicação: " + calculadora.calcular(5, 3, "Multiplicacao"));
    }
}