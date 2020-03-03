import java.util.PriorityQueue;

public class Stone {
    public static int lastStoneWeight(int[] stones) {
        //建大堆
        PriorityQueue<Integer>qp=new PriorityQueue<>((i1, i2) -> i2 - i1);
        for(int val:stones){
            qp.offer(val);
        }
        while(qp.size()>1){
            //取最大的两块石头
            int s1=qp.poll();
            int s2=qp.poll();
            if(s1>s2){
                qp.offer(s1-s2);
            }
        }
        if(!qp.isEmpty()){
            return qp.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[]stones={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
