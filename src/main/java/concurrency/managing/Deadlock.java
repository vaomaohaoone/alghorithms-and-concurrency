package concurrency.managing;

public class Deadlock {

    /*
     * Поток 1 ждёт лока от потока 0. Почему так выходит? Thread-1 начинает выполнение и выполняет метод Friend#bow.
     * Он помечен ключевым словом synchronized, то есть мы забираем монитор по this. Мы на вход в метод получили ссылку
     * на другого Friend. Теперь, поток Thread-1 хочет выполнить метод у другого Friend, тем самым получив лок и у него.
     * Но если другой поток (в данном случае Thread-0) успел войти в метод bow, то лок уже занят и Thread-1 ждёт Thread-0,
     * и наоборот. Блокировка неразрешимая, поэтому она Dead, то есть мёртвая. Как мёртвая хватка (которую не разжать),
     * так и мёртвая блокировка, из которой не выйти.
     */

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}