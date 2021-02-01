package concurrency.collections;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;

public class SimpleConcurrencyCollections {
    public static void main(String[] args) {
        // concurrent Hash Map
        System.out.println("ConcurrentHashMap test");
        Map<String, Integer> animals = new ConcurrentHashMap<>();
        animals.put("zebra", 30);
        animals.put("lion", 6);
        System.out.println(animals.get("lion"));

        // concurrent linked Queue
        System.out.println("ConcurrentLinkedQueue test");
        Queue<Integer> concurrentQueue = new ConcurrentLinkedQueue<>();
        // offer = add
        concurrentQueue.offer(30);
        concurrentQueue.add(31);
        // peek - чтение без удаления и смещения, poll - чтение с удалением
        System.out.println(concurrentQueue.peek());
        System.out.println(concurrentQueue.poll());
        System.out.println(concurrentQueue.peek());

        // concurrent linked Deque
        System.out.println("ConcurrentLinkedDeque test");
        Deque<Integer> concurrentDeque = new ConcurrentLinkedDeque<>();
        // add = offer = push
        concurrentDeque.add(30);
        concurrentDeque.offer(31);
        concurrentDeque.push(32);
        // pop - чтение с конца и удаление, peek - чтение с начала, poll - чтение с начала и удаление
        System.out.println(concurrentDeque.peek());
        System.out.println(concurrentDeque.pop());
        System.out.println(concurrentDeque.peek());
        System.out.println(concurrentDeque.poll());
        System.out.println(concurrentDeque.peek());
        System.out.println(concurrentDeque.poll());

        // concurrent skip list map - коллекция упорядоченного concurrent словаря
        System.out.println("ConcurrentSkipListMap test (sorted ConcurrentHashMap)");
        Map<String, Integer> sortedAnimals = new ConcurrentSkipListMap<>();
        sortedAnimals.put("wolf", 10);
        sortedAnimals.put("cat", 20);
        sortedAnimals.put("dog", 30);
        System.out.println(sortedAnimals);

        // concurrent skip list set - колллекция упорядоченного concurrent множества
        System.out.println("ConcurrentSkipListSet test (sorted concurrent set)");
        Set<Integer> sortedSet = new ConcurrentSkipListSet<>();
        sortedSet.add(30);
        sortedSet.add(10);
        sortedSet.add(20);
        System.out.println(sortedSet);


    }
}
