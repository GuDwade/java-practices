import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPollTest {
    public static void main(String[] args) {
        //可缓存线程池
        ExecutorService pool=Executors.newCachedThreadPool();
        //定长线程池：
        ExecutorService pool1=Executors.newFixedThreadPool(10);
        //单线程化线程池：
        ExecutorService pool2=Executors.newSingleThreadExecutor();
        //定长线程池
        ExecutorService pool3=Executors.newScheduledThreadPool(5);
    }
}
