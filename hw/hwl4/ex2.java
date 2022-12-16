package hw.hw.hwl4;

import java.util.LinkedList;
import java.util.Scanner;

public class ex2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Введите добавляемое значение");
        enqueue(list,scanner.next());
        System.out.println(list);
        System.out.println("Вывод элемента с удалением: " + dequeue(list));
        System.out.println(list);
        System.out.println("Введите добавляемое значение");
        enqueue(list,scanner.next());
        System.out.println(list);
        System.out.println("Вывод элемента без удаления: " + first(list));
        System.out.println(list);
    }
    public static void enqueue(LinkedList<String> list, String el){
        list.add(el);
    }
    public static String dequeue(LinkedList<String> list){
        String temp = list.getFirst();
        list.removeFirst();
        return temp;
    }
    public static String first(LinkedList<String> list){
        return list.getFirst();
    }
}
