import java.util.concurrent.TimeUnit;

public class State {
    private static class AThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("工作中");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.State[] states = Thread.State.values();
        for (Thread.State state : states) {
            System.out.println(state);
        }

        AThread a = new AThread();
        System.out.println(a.getState());   // NEW
        a.start();
        System.out.println(a.getState());   // RUNNABLE
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a.getState());   // TIMED_WAITING // 因为刚好 a 线程在执行 sleep
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a.getState());   // TERMINATED
        a.interrupt();
        System.out.println(a.getState());   // TERMINATED
    }
}
