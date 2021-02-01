package concurrency.collections;

import java.util.*;

public class CollectionsWrapper {
    public static void main(String[] args) {
        // вместо явного создания объектов concurrent коллекций, можно преобразовывать потоконебезопасные коллекции
        // в синхронизированные с помощью Collections api, но при этом, они не будут Concurrency, потокобезопасными будут только операции get() и set(),
        // примеры:
        List<Integer> integerList = Collections.synchronizedList(new ArrayList<>(Arrays.asList(3, 1, 2)));
        // при итерации по элементам, мы всё равно должны использовать блок synchronized, потому что итератор не синхронизирован
        synchronized (integerList) {
            for (int data: integerList) {
                System.out.println(data);
            }
        }
        // так же, при попытке модификации коллекции во время итерирования, возникнет ConcurrencyModificationException
        Map<String, Integer> zooMap = new HashMap<String, Integer>(){{
            put("penguin", 2);
            put("lion", 3);
        }};

        Map<String, Integer> synchronizedZooMap = Collections.synchronizedMap(zooMap);
        for (String key: synchronizedZooMap.keySet()) {
            synchronizedZooMap.remove(key);
        }
    }
}
