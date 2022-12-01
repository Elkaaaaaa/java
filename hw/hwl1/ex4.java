package hw.hw.hwl1;

import java.util.Scanner;
/*
Задано уравнение вида q + w = e, где q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет.
 */
public class ex4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите q: ");
        String q = scanner.next();
        System.out.println("Введите w: ");
        String w = scanner.next();
        int e = getNumbInt();
        String temp = "?";
        for (int i = 0; i < 10; i++) {
            String temp_i = Integer.toString(i);
            Integer new_q = Integer.valueOf(q.replace(temp, temp_i));
            for (int j = 0; j < 10; j++) {
                String temp_j = Integer.toString(j);
                Integer new_w = Integer.valueOf(w.replace(temp, temp_j));
                if (new_q + new_w == e){
                    System.out.println(new_q + "+" + new_w + "=" + e);
                }
            }
        }
    }
    public static int getNumbInt() {
        System.out.println("Введите е: ");
        int numb;
        if (scanner.hasNextInt()) {
            numb = scanner.nextInt();
        } else {
            System.out.println("Это не целое число. Попробуйте еще раз.");
            numb = getNumbInt();
        }
        return numb;
    }
}
