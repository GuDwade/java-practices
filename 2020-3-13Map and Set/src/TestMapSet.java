import java.util.*;

class IntComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}

public class TestMapSet {

    public static void testMap(){
        Map<String,String> map=new TreeMap<>();
        //key 不重复 ，value 可以重复
        //插入: put: key不存在，直接插入  key存在 ，修改对应value
        map.put("顾富成","11101");
        map.put("李二","11102");


        System.out.println(map.get("顾富成"));
        map.put("顾富成","11103");
        System.out.println(map.get("顾富成"));
        System.out.println(map.size());
        System.out.println(map.getOrDefault("顾富成","hahah"));
        System.out.println(map.getOrDefault("顾","hahah"));



        System.out.println(map.containsKey("顾富成"));
        System.out.println(map.containsValue("11182"));

        System.out.println("keySet");
        Set<String>keySet=map.keySet();
        for(String key:keySet){
            System.out.println(key);
        }

        System.out.println("value");
        Collection<String>values=map.values();
        for(String val:values){
            System.out.println(val);
        }

        System.out.println("K-V");
        Set<Map.Entry<String,String>>entrySet=map.entrySet();
        for(Map.Entry<String,String>en:entrySet){
            System.out.println(en.getKey()+" ---- "+en.getValue());
        }

    }
    public static  void testSet(){
        //value 不能重复
        Set<Integer>set=new TreeSet<>(new IntComparator());
        set.add(10);
        set.add(1);
        set.add(13);
        set.add(4);
        set.add(5);
        for(int i:set){
            System.out.print(i+" ");
        }
        System.out.println();

        // TreeSet 搜索树中序遍历 结果有序
        System.out.println("迭代器遍历:");
        Iterator<Integer> it= set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }


    public static void main(String[] args) {
        testMap();
        //testSet();
    }
}
