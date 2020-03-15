import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

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
    
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Map<Node,Node>map=new HashMap<>();
        Node nHead=null;
        Node nTail=null;
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val);
            if(nHead==null){
                nHead=nTail=node;
            }else{
                nTail.next=node;
                nTail=nTail.next;
            }
            map.put(cur,node);
            cur=cur.next;
        }
        cur=head;
        nTail=nHead;
        while(cur!=null){
            if(cur.random!=null){
                // 构建random
                Node random=map.get(cur.random);
                nTail.random=random;
            }
            cur=cur.next;
            nTail=nTail.next;
        }
        return  nHead;
    }

}
