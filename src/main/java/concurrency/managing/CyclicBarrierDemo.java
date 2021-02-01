package concurrency.managing;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public void removeAnimals() {
        System.out.println("Removing animals");
    }

    public void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    public void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {

        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            CyclicBarrierDemo demo = new CyclicBarrierDemo();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen cleaned!!!"));
            for (int i = 0; i < 4; i++) {
                service.submit(() -> demo.performTask(c1, c2));
            }
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
