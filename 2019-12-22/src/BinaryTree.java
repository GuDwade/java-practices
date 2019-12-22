import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class  Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

//找节点
public class BinaryTree {
    public Node find(Node root,int value){
        if(root==null){
            return root;
        }
        if(root.val!=value){
            return root;
        }
        Node node=find(root.left,value);
        if(node!=null){
            return node;
        }
        return  find(root.left,value);
    }

    //遍历储存
    public void inorder(Node root,List<Integer>list){
        if(root!=null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }
    public List<Integer> inorderTraversal(Node root){
        List<Integer>list=new ArrayList<>();
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;
    }

    //判断相同树
    public boolean  isSameTree(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        return root1.val==root2.val
                &&root1.left.val==root2.left.val
                &&root1.right.val==root2.right.val;
    }
    //是否为子树
    public boolean isSubTree(Node s,Node t){
        if(s==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSameTree(s.left,t)){
            return true;
        }
        return isSameTree(s.right,t);
    }

    //最大深度
    public int maxDepth(Node root){
        return root==null ? 0:Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
    //平衡树
    public boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.abs(left-right)<2
                &&isBalanced(root.left)
                &&isBalanced(root.right);
    }

    //镜像对称

    public boolean _isSymmetric(Node left,Node right){
        if(left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        return left.val==right.val
                &&_isSymmetric(left.left,right.right)
                &&_isSymmetric(left.right,right.left);
    }
    public boolean  isSymmetric(Node root){
        if(root==null){
            return true;
        }
        return  _isSymmetric(root.left,root.right);
    }
    //层次遍历
    public  void LevelOrder(Node root){
        Queue<Node> queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            Node topNode=queue.poll();
            System.out.print(topNode.val);
            if (topNode.left!=null){
                queue.offer(topNode.left);
            }
            if (topNode.right!=null){
                queue.offer(topNode.right);
            }
        }
    }

    public boolean isComPleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            Node topNode = queue.poll();
            if (topNode == null) {
                break;
            }
            queue.offer(topNode.left);
            queue.offer(topNode.right);
        }
            while(!queue.isEmpty()){
                Node topNode=queue.poll();
                if(topNode!=null){
                    return false;
                }
            }
            return true;
        }

    public  List  levelOrder2(Node root){
        List<List<Integer>> Mat=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int sz=queue.size();
            List<Integer>rowNode=new ArrayList<>();
            while(sz>0) {
                Node topNode = queue.poll();
                rowNode.add(topNode.val);
                if (topNode.left!=null){
                    queue.offer(topNode.left);
                }
                if (topNode.right!=null){
                    queue.offer(topNode.right);
                }
                --sz;
            }
            Mat.add(rowNode);
        }
        return Mat;
    }
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        BinaryTree bt=new BinaryTree();
        bt.LevelOrder(node1);

    }
}
