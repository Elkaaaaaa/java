package hw.hw.hwl3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<ArrayList<String>> list = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            int flagCheck;
            System.out.println("""
                    Выберете действие:
                    0.Выйти
                    1.Добавить новую книгу
                    2.Напечатать полынй список книг""");
            String temp = scanner.next();
            if (isDigit(temp)) {
                flagCheck = Integer.parseInt(temp);
                if (flagCheck == 1) {
                    addBook(list);
                } else if (flagCheck == 0) {
                    flag = false;
                } else if (flagCheck == 2) {
                    for (ArrayList<String> books : list) {
                        System.out.println(books);
                    }
                } else {
                    System.out.println("Такого действия нет");
                }
            } else {
                System.out.println("Такого действия нет");
            }
        }
    }

    public static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void addBook(List<ArrayList<String>> list) {
        System.out.println("Напишите название жанра добавляемой книги: ");
        String genre = scanner.next();
        boolean flag = false;
        for (ArrayList<String> genres : list) {
            if (genres.contains(genre)) {
                flag = true;
                System.out.println("Напишите название добавляемой книги: ");
                String name = scanner.next();
                genres.add(name);
            }
        }
        if (!flag) {
            ArrayList<String> newGenre = new ArrayList<>();
            list.add(newGenre);
            newGenre.add(genre);
            System.out.println("Напишите название добавляемой книги: ");
            String name = scanner.next();
            newGenre.add(name);
        }
    }
}

