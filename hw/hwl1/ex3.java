package hw.hwl1;

import hw.hwl2.ex2;

import java.io.IOException;
import java.nio.file.Path;
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
        int num1 = getNumbInt();
        int num2 = getNumbInt();
        char operation = getSimpleOperation();
        int result = calc(num1, num2, operation);
        log.info("Результат операции: " + result);
        System.out.println("Результат операции: " + result);
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
        Logger log = Logger.getLogger(ex2.class.getName());
        String str = "hw\\hwl1\\";
        str = str + fileName;
        Path path = Path.of(str).toAbsolutePath();
        FileHandler fh = new FileHandler(path.toString());
        log.addHandler(fh);
        SimpleFormatter smpl = new SimpleFormatter();
        fh.setFormatter(smpl);
        return log;
    }
}

