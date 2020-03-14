import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Problems {

    public int numJewelsInStones(String J, String S) {
        Set<Character>set=new TreeSet<>();
        for(char ch:J.toCharArray()){
            set.add(ch);
        }
        int count=0;
        for(char ch:S.toCharArray()){
            if(set.contains(ch)){
                count++;
            }
        }
        return count;

    }

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            /*
            Integer n=map.get(num);
            if(n==null){
                map.put(num,1);
            }else{
                n++;
                map.put(num,n);
            }
            */
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num:nums){
            if(map.get(num)==1){
                return num;
            }
        }
        return -1;
    }
    //随机链表的复制
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node cur=head;
        while(cur!=null){
            Node copy=new Node(cur.val);
            copy.next=cur.next;
            cur.next=copy;
            cur=copy.next;
        }
        cur=head;
        while(cur!=null){
            Node copy=cur.next;
            if(cur.random!=null){
                copy.random=cur.random.next;
            }
            cur=copy.next;
        }
        cur=head;
        Node nHead=cur.next;
        while(cur!=null){
            Node copy=cur.next;
            cur.next=copy.next;
            if(copy.next!=null){
                copy.next=copy.next.next;
            }
            cur=cur.next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String right=scanner.nextLine();
        String wrong=scanner.nextLine();
        Set<Character>wrongSet=new HashSet<>();
        for(char ch:wrong.toCharArray()){
            wrongSet.add(ch);
        }
        Set<Character>printSet=new HashSet<>();
        for(char ch:right.toCharArray()){
            if (!wrongSet.contains(ch)){
                char a=Character.toUpperCase(ch);
                if(!printSet.contains(a)){
                    printSet.add(a);
                    System.out.print(a);
                }
            }
        }
    }
}
