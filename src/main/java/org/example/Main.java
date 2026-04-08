package org.example;

public class Main {
    public static void main(String[] args) {
        EquationSystem eq = new EquationSystem();
        Double x = 1.0;
        Double eps = 0.00001;
        System.out.println(eq.calculate(x, eps));
    }
}