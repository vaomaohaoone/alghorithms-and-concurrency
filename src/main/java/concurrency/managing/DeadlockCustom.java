package concurrency.managing;

public class DeadlockCustom {


    static class MyResource {

        private int sum;

        MyResource(int sum) {
            this.sum = sum;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MyResource myResource1 = new MyResource(100);
        final MyResource myResource2 = new MyResource(100);

        new Thread(() -> transaction(myResource1, myResource2, 100)).start();
        //Thread.sleep(1000);
        new Thread(() -> transaction(myResource2, myResource1, 100)).start();

    }

    public static void transaction(MyResource from, MyResource to, int count) {
        synchronized (from) {
            System.out.println(String.format("Sum from before transaction: %d", from.getSum()));
            from.setSum(from.getSum() - count);
            synchronized (to) {
                System.out.println(String.format("Sum to before transaction: %d", to.getSum()));
                to.setSum(to.getSum() + count);
            }
        }
        System.out.println(String.format("Sum from after transaction: %d", from.getSum()));
        System.out.println(String.format("Sum to after transaction: %d", to.getSum()));
    }
}
