package concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledSingleThreadExecutorDemo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> {
            System.out.println("Task 1");
        };

        Runnable task2 = () -> {
            System.out.println("Task 2");
        };

        Runnable task3 = () -> {
            System.out.println("Task 3");
        };

        scheduledService.schedule(task1, 5, TimeUnit.SECONDS);
        scheduledService.schedule(task2, 2, TimeUnit.SECONDS);
        scheduledService.scheduleAtFixedRate(task3, 3, 5, TimeUnit.SECONDS);

        Thread.sleep(15000);
        scheduledService.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
