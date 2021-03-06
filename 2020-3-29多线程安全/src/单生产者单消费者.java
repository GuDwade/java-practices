import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class 单生产者单消费者 {
    private static CircleQueue queue = new CircleQueue();

    private static class 生产者 extends Thread {
        生产者() {
            super("生产者");
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    System.out.print("请输入下一个数字: ");
                    int element = scanner.nextInt();
                    queue.put(element);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class 消费者 extends Thread {
        消费者() {
            super("消费者");
        }

        @Override
        public void run() {
            Random random = new Random(20200405);
            try {
                while (true) {
                    int element = queue.take(); // 如果队列为空，则阻塞
                    System.out.println("消费者取出: " + element);
                    // 等待随机秒，最多 10 s
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread pro=new 生产者();
        pro.start();
        Thread cus=new 消费者();
        cus.start();
    }
}
