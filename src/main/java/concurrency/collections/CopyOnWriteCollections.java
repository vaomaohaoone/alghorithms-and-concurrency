package concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollections {
    public static void main(String[] args) {
        // при каждом изменении массива, происходит создание нового массива и копирование всех элементов старого массива в новый
        // то же самое с CopyOnWriteArraySet
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(3, 1, 2));
        for (Integer number: list) {
            System.out.println(number);
            list.add(4);
        }
        System.out.println(list);
    }
}
