package hw.hw.hwl4;

import hw.hw.hwl2.ex4;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ex3 {
    static Scanner scanner = new Scanner(System.in);
    static Logger log;

    static {
        try {
            log = logger("logEx3.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> resultList = new LinkedList<>();
        int num1 = getNumbInt();
        resultList.add(num1);
        int num2 = getNumbInt();
        char operation = getSimpleOperation();
        int result = calc(num1, num2, operation);
        log.info("Результат операции: " + result);
        System.out.println("Результат операции: " + result);
        resultList.add(result);
        while (true) {
            System.out.println("""
                    Желаете продолжить с данным числом?
                    1-Да
                    2-Нет""");
            String flag = scanner.next();

            if (flag.contains("2")) {
                log.info("Завершение программы");
                System.out.println("Хорошего дня!");
                break;
            } else if (flag.contains("1")) {
                log.info("Продолжение работы с числом: " + result);
                while (true) {
                    System.out.println("Ваш последний результат: " + result + """
                            \nЧто жедаете с ним сделать?
                            1-Отменить операцию
                            2-Продолжить вычисление""");
                    flag = scanner.next();
                    log.info("Пользователь ввел: "+ flag);
                    if (flag.contains("1")) {
                        if (resultList.size() == 1) {
                            System.out.println("""
                                    Вы уже отменили все операции
                                    Ваш последний результат:""" + result);
                        }else {
                            log.info("Отмена последней операции");
                            resultList.removeLast();
                            result = resultList.getLast();
                            System.out.println("Результат операции: " + result);
                            log.info("Результат операции: " + result);
                        }
                        break;
                    } else if (flag.contains("2")) {
                        log.info("Продолжение вычислений с последним результатом: " + result);
                        num1 = result;
                        num2 = getNumbInt();
                        operation = getSimpleOperation();
                        result = calc(num1, num2, operation);
                        resultList.add(result);
                        System.out.println("Результат операции: " + result);
                        break;
                    } else {
                        log.info("Такого варианта нет: " + flag);
                        System.out.println("Такого варианта нет, давай еще раз");
                    }
                }
            } else {
                log.info("Такого варианта нет: " + flag);
                System.out.println("Такого варианта нет, давай еще раз");
            }
        }
    }

    public static int getNumbInt() {
        System.out.println("Введите целое число:");
        int numb;
        if (scanner.hasNextInt()) {
            numb = scanner.nextInt();
            log.info("Пользователь ввел число: " + numb);
        } else {
            log.info("Пользователь ввел некорректные данные: " + scanner.next());
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
            log.info("Пользователь выбрал операцию: " + operation);
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
                log.info("Пользователь ввел некорректные данные: " + operation);
                result = calc(num1, num2, getSimpleOperation());
            }
        }
        return result;
    }

    public static Logger logger(String fileName) throws IOException {
        Logger log = Logger.getLogger(ex3.class.getName());
        String str = ex3.class.getPackage().getName().replace('.', '\\') + "\\";
        str = str + fileName;
        Path path = Path.of(str).toAbsolutePath();
        FileHandler fh = new FileHandler(path.toString());
        log.addHandler(fh);
        SimpleFormatter smpl = new SimpleFormatter();
        fh.setFormatter(smpl);
        return log;
    }
}
