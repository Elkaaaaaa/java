package hw.hw.hwl1;


import java.io.IOException;
import java.util.Scanner;
/*
    Реализовать простой калькулятор
 */
public class ex3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int num1 = getNumbInt();
        int num2 = getNumbInt();
        char operation = getSimpleOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static int getNumbInt() {
        System.out.println("Введите целое число:");
        int numb;
        if (scanner.hasNextInt()) {
            numb = scanner.nextInt();
        } else {
            System.out.println("Это не целое число. Попробуйте еще раз.");
            numb = getNumbInt();
        }
        return numb;
    }

    public static char getSimpleOperation() {
        System.out.println("Введите операцию (*, /, +, -):");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Это не совсем то, что нужно. Попробуйте еще раз.");
            scanner.next();
            operation = getSimpleOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Такого не умею. Повторите ввод (*, /, +, -).");
                result = calc(num1, num2, getSimpleOperation());
            }
        }
        return result;
    }
}

