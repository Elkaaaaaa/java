package hw.hw.hwl5;

import java.util.*;

public class ex2 {

    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (K key: map.keySet())
        {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Integer> list = new HashMap<>();
        int count;
        String names = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов";
        LinkedList<String> namesLst = new LinkedList<>(Arrays.asList(names.split(" ")));
        for (int i = 0; i < namesLst.size(); i = i + 2) {
            String temp = namesLst.get(i);
            if (list.containsKey(temp)) {
                count = list.get(temp) + 1;
                list.put(temp, count);
            } else {
                list.put(temp, 1);
            }
        }
        List<Integer> counterList = new ArrayList<>(List.copyOf(list.values()));
        Collections.sort(counterList);
        Collections.reverse(counterList);
        for (var item : counterList) {
            if (list.containsValue(item)){
                System.out.printf("Имя %s появляется %d раз\n", getKey(list,item), list.get(getKey(list,item)));
            }
        }

    }
}
