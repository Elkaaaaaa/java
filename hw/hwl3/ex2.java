package hw.hw.hwl3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbs = new ArrayList<>();
        int count = getNumbInt("Введите количество чисел в списке");
        for (int i = 0; i < count; i++) {
            int a = (int) (Math.random() * 100);
            numbs.add(a);
        }
        System.out.println(numbs);
        List<Integer> temp = new ArrayList<>(numbs);
        for (int numb: numbs) {
            if (numb%2==0){
                temp.remove((Integer) numb);
            }
        }
        System.out.println(temp);
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
