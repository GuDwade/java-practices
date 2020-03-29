import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Security {
    private static long n = 0;

    static class Add extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000_0000; i++) {
                n++;
            }
        }
    }

    static class Sub extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000_0000; i++) {
                n--;
            }
        }
    }
    private static long COUNT = 1_0000_0000L;

    private static class Count extends Thread {
        @Override
        public void run() {
            long n = 0;
            for (int i = 0; i < COUNT; i++) {
                n += i;
            }
            System.out.println(n);
        }
    }

    private static boolean running = true;

    private static class Child extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (running) {
                n++;
            }

            System.out.println(n);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //两个线程共享n,并修改，可能不安全
        Sub sub = new Sub();
        sub.start();
        Add add = new Add();
        add.start();

        add.join();
        sub.join();

        System.out.println(n);

        //共享count，不做修改，各干各的
        Thread t1=new Count();
        Thread t2=new Count();
        Thread t3=new Count();
        Thread t4=new Count();
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        Thread t = new Child();
        t.start();

        Scanner scanner = new Scanner(System.in);
        System.out.print("随便输入什么，让子线程退出: ");
        scanner.nextLine();

        System.out.println(running);    //ture
        running = false;
        System.out.println(running);    //false

        //主线程更改running ,t线程不知道
        while (true) {
            System.out.println(t.getState()); //Runnable
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
