package hw.hw.hwl5;

import java.util.*;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);

    public static int getNumbInt() {
        System.out.println();
        int numb;
        if (scanner.hasNextInt()) {
            numb = scanner.nextInt();
        } else {
            System.out.println("Это не целое число. Попробуйте еще раз.");
            scanner.next();
            numb = getNumbInt();
        }
        return numb;
    }

    public static void main(String[] args) {
        Map<String, List<String>> phoneList = new HashMap<>();
        String name;
        System.out.println("""
                Добро пожаловать в телефонный справочник""");
        while (true) {
            System.out.println("""
                    Выберете действие из списка:
                    0.Завершение работы
                    1.Показать номера
                    2.Добавить новый номер
                    3.Удалить уже имеющийся номер""");
            String key = scanner.next();
            if (key.contains("0")) {
                break;
            } else if (key.contains("1")) {
                if (phoneList.isEmpty()) {
                    System.out.println("Список номеров пуст");
                } else {
                    for (var names : phoneList.entrySet()) {
                        System.out.println(names.getKey());
                        for (String number : names.getValue()) {
                            System.out.println("\t" + number);
                        }
                    }
                }
            } else if (key.contains("2")) {
                System.out.println("Введите ФИО добавляемого контакта");
                name = scanner.next();
                System.out.println("Введите номер добавляемого контакта");
                String number = scanner.next();
                LinkedList<String> temp = new LinkedList<>();
                if (phoneList.containsKey(name)) {
                    temp.addAll(phoneList.get(name));
                }
                temp.add(number);
                phoneList.put(name, temp);
            } else if (key.contains("3")) {
                List<String> temp;
                System.out.println("Введите имя удаляемоего контакта");
                name = scanner.next();
                for (var el : phoneList.entrySet()) {
                    if (Objects.equals(el.getKey(), name)) {
                        System.out.println("Выберете удаляемый номер");
                        System.out.println("0.Выход");
                        Map<Integer, String> tempo = new HashMap<>();
                        int i = 1;
                        for (String number : el.getValue()) {
                            tempo.put(i, number);
                            System.out.printf("%d. %s\n", i, number);
                            i++;
                        }
                        while (true) {
                            int value = getNumbInt();
                            if (tempo.containsKey(value)) {
                                temp = phoneList.get(name);
                                temp.remove(value - 1);
                                break;
                            } else if (value == 0){
                                break;
                            } else {
                                System.out.println("Такого номера нет, повторите попытку");
                            }
                        }

                    } else {
                        System.out.println("Такого контакта нет");
                    }
                }
            }
        }
    }
}
