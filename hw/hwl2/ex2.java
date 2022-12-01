package hw.hw.hwl2;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ex2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Integer> numbs = getList();
        System.out.println(numbs);
        Logger log = logger("logEx2.txt");
        int temp;
        int c = 0;
        while (c != numbs.size()) {
            for (int i = 0; i < numbs.size(); i++) {
                try {
                    if (numbs.get(i) > numbs.get(i + 1)) {
                        temp = numbs.get(i);
                        numbs.set(i, numbs.get(i + 1));
                        numbs.set(i + 1, temp);
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
            log.info(numbs.toString());
            c++;
        }
        System.out.println(numbs);
    }

    public static Logger logger(String fileName) throws IOException {
        Logger log = Logger.getLogger(ex2.class.getName());
        String str = "hw\\hwl2\\";
        str = str + fileName;
        Path path = Path.of(str).toAbsolutePath();
        FileHandler fh = new FileHandler(path.toString());
        log.addHandler(fh);
        SimpleFormatter smpl = new SimpleFormatter();
        fh.setFormatter(smpl);
        return log;
    }
    public static @NotNull List<Integer> getList() {
        int length = getNumbInt("Колличество элементов массива: ");
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int a = getNumbInt("Введите элемент массива");
            result.add(a);
        }
        return result;
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
