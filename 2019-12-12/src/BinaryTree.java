class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
//前序遍历
public class BinaryTree {
    public static int size=0;
    public static int leafSize=0;
    public void preOrder(Node root){
        if(root==null){
            return;
        }else{
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
//中序遍历
    public void midOrder(Node root){
        if(root==null){
            return;
        }else{
            midOrder(root.left);
            System.out.print(root.val);
            midOrder(root.right);
        }
    }
//后序遍历
    public  void latOrder(Node root){
        if(root==null){
            return;
        }else{
            midOrder(root.left);
            midOrder(root.right);
            System.out.print(root.val);
        }
    }

    public void getSize1(Node root){
        if(root==null){
            return;
        }else{
            size++;
            getSize1(root.left);
            getSize1(root.right);
        }
    }

    public int getSize2(Node root){
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else{
            return getSize2(root.left)+getSize2(root.right)+1;
        }
    }

    public void getLeafSize1(Node root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    public int getLeafSize2(Node root){
        if(root==null){
            return 0;
        }else if(root.right==null&&root.left==null){
            return 1;
        }else{
            return getLeafSize2(root.left)+getLeafSize2(root.right);
        }
    }
    public int getKsize(Node root ,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKsize(root.left, k-1)+getKsize(root.right,k-1);
    }
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        node3.left=node5;
        BinaryTree bT=new BinaryTree();
        bT.latOrder(node1);
        System.out.println(" ");
        bT.midOrder(node1);
        System.out.println(" ");
        bT.preOrder(node1);
        System.out.println(" ");
        bT.getSize1(node1);
        System.out.println(bT.size);
        System.out.println(bT.getSize2(node1));
        bT.getLeafSize1(node1);
        System.out.println(bT.leafSize);
        System.out.println(bT.getLeafSize2(node1));
        System.out.println(bT.getKsize(node1,3));
    }
}
