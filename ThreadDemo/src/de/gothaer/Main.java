package de.gothaer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        new Main().go();
    }

    private void go() {

        try {
            ExecutorService service = Executors.newFixedThreadPool(10);

            for(int i = 0; i < 10 ; i ++) {
                service.execute(new MyWorker());
            }

            service.execute(this::blaBlupp);

            service.execute(()->{
                System.out.println("Erster!");
            });

            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            System.out.println("Fertig!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void blaBlupp() {
        try {
            Random random = new Random();
            long value = random.nextInt(2000);
            Thread.sleep(value);
            System.out.println(Thread.currentThread().getId() + " ist nach " + value + "millis beendet");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    class MyWorker implements Runnable {

        private Random random = new Random();

        @Override
        public void run() {
            try {
                long value = random.nextInt(2000);
                Thread.sleep(value);
                System.out.println(Thread.currentThread().getId() + " ist nach " + value + "millis beendet");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}