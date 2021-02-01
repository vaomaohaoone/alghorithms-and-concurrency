package concurrency.collections;

import java.util.concurrent.*;

public class BlockingQueueConcurrencyCollections {
    public static void main(String[] args) {
        try {
            System.out.println("LinkedBlockingQueue test");
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(30);
            blockingQueue.offer(31, 2, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        }catch (InterruptedException e) {

        }

        try {
            System.out.println("LinkedBlockingDeque test");
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(30);
            blockingDeque.offer(31, 2, TimeUnit.SECONDS);
            blockingDeque.offerFirst(32, 2, TimeUnit.SECONDS);
            blockingDeque.offerLast(33, 2, TimeUnit.SECONDS);
            System.out.println(blockingDeque.peek());
            System.out.println(blockingDeque.poll(1, TimeUnit.SECONDS));
            System.out.println(blockingDeque.pollFirst(1, TimeUnit.SECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        }catch (InterruptedException ex) {

        }

    }
}
