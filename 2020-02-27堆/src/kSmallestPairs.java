import java.util.*;

public class kSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // PriorityQueue默认是一个小顶堆,可以通过传入自定义的Comparator函数来实现大顶堆
        Queue<int[]> maxHeap = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return sum(o2) - sum(o1);
            }
        });
        for(int n1:nums1){
            for(int n2:nums2){
                int []tmp={n1,n2};
                if(maxHeap.size()<k){
                    maxHeap.offer(tmp);
                }else if(sum(maxHeap.peek())>sum(tmp)){
                    //比最大的小就入堆
                    maxHeap.poll();
                    maxHeap.offer(tmp);
                }
            }
        }
        List<List<Integer>>ret=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            List<Integer>list=new ArrayList<>();
            int[]tmp=maxHeap.poll();
            list.add(tmp[0]);
            list.add(tmp[1]);
            ret.add(list);
        }
        return  ret;

    }
    public int sum(int[] nums) {
        return nums[0] + nums[1];
    }
}
