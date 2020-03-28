import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Interrupt {
    //1.自定义的标志通知停止
    public static class Condition {
        public volatile boolean running = true;
    }


    public static class B extends Thread {
        private Condition condition;

        B(Condition condition) {
            this.condition = condition;
        }

        @Override
        public void run() {
            Thread thread = currentThread();
            // 只要 condition.running = false 我就停了
            while (condition.running) {
                try {
                    System.out.println(thread.getId() + ": 挖煤");
                    TimeUnit.SECONDS.sleep(5);  //如果进入到休眠状态，不会知道停止
                } catch (InterruptedException e) {
                }
            }
        }
    }
    //2.java提供的方式通知停止
    public static class A extends Thread {
        @Override
        public void run() {

            while (Thread.interrupted() == false) {
                try {
                    System.out.println("挖煤");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        /*
        Thread main = Thread.currentThread();
        System.out.println("主线程 id: " + main.getId());
        Condition condition = new Condition();

        B b = new B(condition);
        b.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("随便输入什么，都会让子线程停止挖煤");
        scanner.nextLine();

        condition.running = false;
        */

        A a = new A();
        a.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        a.interrupt();
    }
}
