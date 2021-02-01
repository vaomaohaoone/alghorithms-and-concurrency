package concurrency;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class T {
    @Override
    public String toString() {
        return "T";
    }
}

class Printer<T> {
    private T t;
    Printer(T t){
        this.t = t;
    }
    @Override
    public String toString(){
        return t.toString();
    }
}

public class Test {
    public static void main(String[] args) {
        Printer<T> obj = new Printer<>(new T());
        System.out.println(obj);
    }
}