import java.util.Scanner;

public class Pratice {

    //线程的优势
    //1.提升速度     通过添加新的调度单位，可以争抢到更多的CPU资源
    //2.阻塞场景下   通过添加新的调度单位，阻塞一个调度单位，不影响其他调度单位争抢CPU资源

    private static final long COUNT = 10_0000_0000L;
    private static final int N = 10;                // 一共计算 10 次

    private static void calc() {
        long r = 0;
        for (long i = 0; i < COUNT; i++) {
            r += i;
        }
        System.out.println(r);
    }

    private static class  CalcThread extends  Thread{
        @Override
        public void run() {
            calc();
        }
    }

    private static long fib(int x){
        if(x<=2){
            return x;
        }
        return fib(x-1)+fib(x-2);
    }

    private static class FibThread extends Thread {
        private int n;
        FibThread(int n) {
            this.n = n;
        }
        @Override
        public void run() {
            System.out.println(fib(n));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
        //主线程执行十次
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            calc();
        }
        long end = System.nanoTime();
        double time = (end - start) * 1.0 / 1000 / 1000;
        System.out.println("主线程耗时: " + time);


        //多线程执行
        long start1 = System.nanoTime();
        CalcThread[] threads=new CalcThread[N-1];
        for(int i=0;i<N-1;i++){
            CalcThread thread=new CalcThread();
            thread.start();
            threads[i]=thread;
        }

        calc();

        for(int i=0;i<N-1;i++){
            threads[i].join();
        }
        long end1 = System.nanoTime();
        double time1 = (end1 - start1) * 1.0 / 1000 / 1000;
        System.out.println("多线程耗时: " + time1);
        */

        //
        Scanner scanner=new Scanner(System.in);
        while(true){
            int x=scanner.nextInt();
            //System.out.println(fib(x));     //计算量太大 阻塞

            FibThread thread=new FibThread(x);    // 重新启动一个线程，去计算 fib(n)
            thread.start();
        }

    }
}
