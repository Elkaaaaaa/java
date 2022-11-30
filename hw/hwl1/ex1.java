package hw.hwl1;

import java.util.Scanner;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getNumbInt("Введите n: ");
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        System.out.printf("Сумма чисел от 1 до %d = %d\n", n, result);
        result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        System.out.printf("Произведение чисел от 1 до %d = %d", n, result);
    }

    public static int getNumbInt(String text) {
        System.out.println(text);
        int numb;
        if (scanner.hasNextInt()) {
            numb = scanner.nextInt();
        } else {
            System.out.println("Это не целое число. Попробуйте еще раз.");
            scanner.next();
            numb = getNumbInt(text);
        }
        return numb;
    }
}