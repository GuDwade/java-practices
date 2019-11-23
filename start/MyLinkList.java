class Node{
	int val;
	Node next;
	Node(int val,Node next){
		this.val=val;
		this.next=next;
	}
	Node(int val){
		this(val,null);
	}
}
public class MyLinkList{
	public static Node bulidMyLinkList(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		return n1;
	}
	public  static  void print(Node head){
		Node cur=head;
		while(cur!=null){
			System.out.println(cur.val);
			cur=cur.next;
		}
	}
	public static Node pushFront(Node head,int val){//头插
		Node node=new Node(val);
		node.next=head;
		return node;
	}
	public static Node popFront(Node head){//头删
		if(head==null){
			throw new RuntimeException("空链表");
		}
		return head.next;
	}
	public static Node pushBack(Node head,int val){//尾插
		Node node =new Node(val);
		if(head==null){
			return node;
		}
		Node cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		cur.next=node;
		return head;
	}
	public static Node popback(Node head){//尾删
		if(head==null){
			throw new RuntimeException("空的");
		}
		if(head.next==null){
			return null;
		}else{
			Node cur=head;
			while(cur.next.next!=null){
			cur=cur.next;
			}
			cur.next=null;
			return head;
		}
	}
	public static void main(String[]args){
		// Node head=bulidMyLinkList();
		// print(head);
		Node head=null;
		head=pushFront(head,0);
		head=pushFront(head,1);
		head=pushFront(head,2);
		head=pushFront(head,3);
		print(head);
		head=popFront(head);
		print(head);
		head=popback(head);
		print(head);
		head=pushBack(head,5);
		print(head);
		
	}
}