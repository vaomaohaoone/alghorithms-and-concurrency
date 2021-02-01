package concurrency.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamParallelPerformanceDemo {

    public int increaseRecord(int record) {
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException interruptedException) {

        }
        return record + 1;
    }

    public int processAllDataSerialStream(List<Integer> data) {
        return data.stream().map(this::increaseRecord).mapToInt(Integer::intValue).sum();
    }

    public int processAllDataParallelStream(List<Integer> data) {
        return data.parallelStream().map(this::increaseRecord).mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            integerList.add(i);
        }

        StreamParallelPerformanceDemo demo = new StreamParallelPerformanceDemo();
        //Process data
        long start = System.currentTimeMillis();
        demo.processAllDataSerialStream(integerList);
        double time = (System.currentTimeMillis() - start) / 1000.0;
        // Report result
        System.out.println("Task with serial stream was completed in: " + time + " seconds");

        //Process data
        start = System.currentTimeMillis();
        demo.processAllDataParallelStream(integerList);
        time = (System.currentTimeMillis() - start) / 1000.0;
        // Report result
        System.out.println("Task with parallel stream was completed in: " + time + " seconds");

    }
}
