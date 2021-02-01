package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadRaceCondition {

    // если вместо атомарной переменной использовать int, будет RaceCondition, атомарные переменные позволяют от них избавиться
    private AtomicInteger sheepCount;

    public ThreadRaceCondition(AtomicInteger sheepCount) {
        this.sheepCount = sheepCount;
    }

    // если поставить synchronized, то доступ к монитору объекта будет только для одного потока
    private void incrementAndReport() {
        System.out.println("Sheep count is: " + sheepCount.incrementAndGet());
    }

    public static void main(String[] args) {
        ThreadRaceCondition threadRaceCondition = new ThreadRaceCondition(new AtomicInteger(0));
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 10; i++) {
                executorService.submit(threadRaceCondition::incrementAndReport);
            }
        }finally {
            if (executorService != null)
                executorService.shutdown();
        }
    }
}
