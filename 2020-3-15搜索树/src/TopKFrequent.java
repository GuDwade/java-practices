import java.util.*;

class EntryComparator implements Comparator<Map.Entry<String, Integer>>{
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int diff = o1.getValue() - o2.getValue();
        if(diff == 0){
            return o2.getKey().compareTo(o1.getKey());
        }
        return diff;
    }
}
public class TopKFrequent {
    //前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //建小堆
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>(new EntryComparator());
        for(Map.Entry<String,Integer> en:map.entrySet()){
            pq.offer(en);
            if(pq.size()>k){
                pq.poll();
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while(!pq.isEmpty()){
            //头插 次数越小越后
            list.addFirst(pq.poll().getKey());
        }
        return list;
    }
}
