package concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> futureResult = service.submit(() -> {
                int sum = 0;
                for (int i = 0; i < 100000; i++) {
                    sum += i;
                }
                Thread.currentThread().sleep(1000);
                return sum;
            });
            while (!futureResult.isDone()) {
                System.out.println("Not done!!!!");
                Thread.currentThread().sleep(500);
            }
            System.out.println("Result: " + futureResult.get());
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
