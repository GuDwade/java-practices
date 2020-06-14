public class CircleQueue {
    private static final int CAPACITY = 5;

    private int[] queue = new int[CAPACITY];
    private int size = 0;
    private int frontIndex = 0;
    private int rearIndex = 0;

    // 放入队列
    public synchronized void put(int element) throws InterruptedException {
        //单消费者if
       while (size==queue.length){
           wait();
       }

       queue[rearIndex]=element;
       rearIndex++;
       if (rearIndex==queue.length){
           rearIndex=0;
       }
       size++;
       System.out.println(size);
       //notify();
        notifyAll();
    }

    // 从队列中取
    public synchronized int take() throws InterruptedException {
        while (size==0){
            wait();
        }

        int element=queue[frontIndex];
        frontIndex++;
        if (frontIndex==queue.length){
            frontIndex=0;
        }

        size--;
        System.out.println(size);
        //notify();
        notifyAll();
        return element;
    }
}
