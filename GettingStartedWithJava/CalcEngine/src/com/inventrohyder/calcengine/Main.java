package com.inventrohyder.calcengine;

public class Main {
    public static void main(String[] args) {
        double value1 = 10;
        double value2 = 10;
        double result;

        char opCode = 'a';

        result = calculate(value1, value2, opCode);

        System.out.println(result);
    }


    static double calculate(double value1, double value2, char opCode) {
        if (opCode == 'a')
            return value1 + value2;
        else if (opCode == 's') {
            return value1 - value2;
        } else if (opCode == 'm') {
            return value1 * value2;
        } else if (opCode == 'd') {
            return value1 / value2;
        } else {
            return 0.00d;
        }
    }
}