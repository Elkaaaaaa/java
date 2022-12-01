package hw.hw.hwl1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
/*
    Вывести все простые числа от 1 до 1000
 */
public class ex2 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            if (splittingIntoMultipliers(i).size() <= 1) {
                System.out.println(i);
            }
        }
    }

    public static @NotNull List<Integer> splittingIntoMultipliers(int number) {
        List<Integer> numbs = new ArrayList<>();
        int k = 2;
        while (number != 1) {
            if (number % k == 0) {
                numbs.add(k);
                number /= k;
            } else {
                k++;
            }
        }
        return numbs;
    }
}
