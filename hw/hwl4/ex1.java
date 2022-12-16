package hw.hw.hwl4;

import java.util.LinkedList;
import java.util.Scanner;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<String> startList = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            System.out.printf("Введите элемент номер %d: \n", i);
            startList.add(scanner.next());
        }
        System.out.println("Начальный список:" + startList);
        System.out.println("'Перевернутый' список:" + revert(startList));
    }
    public static LinkedList<String> revert (LinkedList<String> list){
        LinkedList <String> revertList = new LinkedList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            revertList.add(list.get(i));
        }
        return revertList;
    }
}
