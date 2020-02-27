import java.util.Arrays;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    private int[]array=new int[10];
    private int sz=0;
    //入队
    public void offer(int val) {
        if(sz==array.length){
            Arrays.copyOf(array,array.length*2);
        }
        array[sz++]=val;
        MyHeap.shiftUpSmall(array,sz-1);
    }
    //出队
    public int poll() {
        int ret=array[0];
        array[0]=array[--sz];
        MyHeap.shiftDownSmall(array,sz,0);
        return ret;
    }
    //队首
    public int peek() {
        return array[0];
    }
    //为空
    public boolean isEmpty(){
        return sz==0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        pq.offer(12);
        pq.offer(18);
        pq.offer(32);
        pq.offer(6);
        pq.offer(3);
        pq.offer(7);
        pq.offer(11);
        pq.offer(24);
        while(!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
        System.out.println();
        MyPriorityQueue mpq=new MyPriorityQueue();
        mpq.offer(12);
        mpq.offer(18);
        mpq.offer(32);
        mpq.offer(6);
        mpq.offer(3);
        mpq.offer(7);
        mpq.offer(11);
        mpq.offer(24);
        while(!mpq.isEmpty()){
            System.out.print(mpq.poll()+" ");
        }
        System.out.println();
    }
}
