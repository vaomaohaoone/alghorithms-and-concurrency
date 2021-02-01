package concurrency.managing;

public class NotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        // task будет ждать, пока его не оповестят через lock

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    System.out.println("Start waiting");
                    lock.wait();
                    System.out.println("Wait is ended");
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

        // После оповещения нас мы будем ждать, пока сможем взять лок
            System.out.println("Some operation performed");

        };
        Thread taskThread = new Thread(task);
        taskThread.start();

        // Ждём и после этого забираем себе лок, оповещаем и отдаём лок

        Thread.currentThread().sleep(10000);
        synchronized (lock) {
            lock.notify();
            System.out.println("Lock was notified");
        }
    }
}
