//Find prime numbers using multithreading (Thread, Runnable, Executor Framework)

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program1 {

    static class PrimeThread extends Thread {
        int start, end;

        PrimeThread(int s, int e) {
            start = s;
            end = e;
        }

        boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i <= n / 2; i++)
                if (n % i == 0) return false;
            return true;
        }

        @Override
        public void run() {
            StringBuilder primes = new StringBuilder();
            for (int i = start; i <= end; i++)
                if (isPrime(i)) primes.append(i).append(" ");
            synchronized (System.out) {
                System.out.println("Thread Class: Prime numbers from " + start + " to " + end + " :");
                System.out.println(primes + "\n");
            }
        }
    }

    static class PrimeRunnable implements Runnable {
        int start, end;

        PrimeRunnable(int s, int e) {
            start = s;
            end = e;
        }

        boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i <= n / 2; i++)
                if (n % i == 0) return false;
            return true;
        }

        @Override
        public void run() {
            StringBuilder primes = new StringBuilder();
            for (int i = start; i <= end; i++)
                if (isPrime(i)) primes.append(i).append(" ");
            synchronized (System.out) {
                System.out.println("Runnable Interface: Prime numbers from " + start + " to " + end + " :");
                System.out.println(primes + "\n");
            }
        }
    }

    static class PrimeTask implements Runnable {
        int start, end;

        PrimeTask(int s, int e) {
            start = s;
            end = e;
        }

        boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i <= n / 2; i++)
                if (n % i == 0) return false;
            return true;
        }

        @Override
        public void run() {
            StringBuilder primes = new StringBuilder();
            for (int i = start; i <= end; i++)
                if (isPrime(i)) primes.append(i).append(" ");
            synchronized (System.out) {
                System.out.println("Executor Framework: Prime numbers from " + start + " to " + end + " :");
                System.out.println(primes + "\n");
            }
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {

        System.out.println("=== Prime Numbers Using Multithreading ===\n");

        PrimeThread t1 = new PrimeThread(1, 50);
        PrimeThread t2 = new PrimeThread(51, 100);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread r1 = new Thread(new PrimeRunnable(1, 50));
        Thread r2 = new Thread(new PrimeRunnable(51, 100));
        r1.start();
        r2.start();

        try {
            r1.join();
            r2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new PrimeTask(1, 50));
        executor.execute(new PrimeTask(51, 100));
        executor.shutdown(); 

        try {
            executor.awaitTermination(2, TimeUnit.MINUTES); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== All Tasks Completed ===");
    }
}