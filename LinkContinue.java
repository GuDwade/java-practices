public class LinkContinue {
    public static Node getMiddle(Node head){
        Node cur=head;
        Node getMid=head;
        int sz=0;
        while(cur!=null){
           sz++;
           cur=cur.next;
        }
        for(int i=0;i<sz/2;i++){
            getMid=getMid.next;
        }
        return getMid;
    }
    public static Node reserveList(Node head){
        Node cur=head;
        Node nhead=null;
        while(cur!=null){
            Node next=cur.next;
            cur.next=nhead;
            nhead=cur;
            cur=next;
        }
        return  nhead;
    }
    public static Boolean palindromeList(Node head){
        Node mid=getMiddle(head);
        Node rhead=reserveList(mid);
        Node c1 =head;
        Node c2 = rhead;
        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) {
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }

    public static void main(String[]args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(2);
        Node n5=new Node(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        boolean a=palindromeList(n1);
        System.out.println(a);
    }
}
