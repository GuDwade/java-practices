public class Attribute {

    private static void attributes() {
        Thread thread = Thread.currentThread();

        long id = thread.getId();
        System.out.println(id + ": 线程的唯一标识: " + id);
        String name = thread.getName();
        System.out.println(id + ": 线程的名字: " + name);
        int priority = thread.getPriority();
        System.out.println(id + ": 线程的优先级: " + priority);
        Thread.State state = thread.getState();
        System.out.println(id + ": 线程的当前状态: " + state);
        boolean alive = thread.isAlive();
        System.out.println(id + ": 线程是否还活着: " + alive);
        boolean interrupted = thread.isInterrupted();
        System.out.println(id + ": 线程是否被通知停止: " + interrupted);
        boolean daemon = thread.isDaemon();
        System.out.println(id + ": 线程是否是后台线程: " + daemon);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            attributes();
        }, "张三");
        t1.start();

        Thread t2 = new Thread(() -> {
            attributes();
        }, "李四");
        t2.start();

        attributes();
    }
}
