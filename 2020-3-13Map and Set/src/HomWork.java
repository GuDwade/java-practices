import java.util.*;

public class HomWork {

    public int firstUniqChar(String s) {
        char[]chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ret=-1;
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])==1){
                ret=i;
                break;
            }
        }
        return ret;
    }
    //nums1 = [1,2,2,1], nums2 = [2,2]
    //输出: [2]
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set=new HashSet<>();
        for(int val:nums1){
            set.add(val);
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])&&!list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[]ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return  ret;
    }
    //nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出: [4,9]
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int val:nums1){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        List<Integer>list=new ArrayList<>();
        /*
        for(int i=0;i<nums2.length;i++){
            Integer count=map.get(nums2[i]);
            if(count!=0&&count!=null){
                list.add(nums2[i]);
                map.put(nums2[i],count-1);
            }
        }
        */
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                map.put(num, --count);
            }
        }
        int[]ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return  ret;
    }
}
