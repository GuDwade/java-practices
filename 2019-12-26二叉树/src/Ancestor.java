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
public class Ancestor {
    public boolean find(Node root,Node node){
        if(root==null){
            return false;
        }
        if(root==node){
            return true;
        }
        if(find(root.left,node)){
            return true;
        }
        return find(root.right,node);
    }
    public Node nearAncestor(Node root,Node p,Node q){
        boolean pL=false;
        boolean pR=false;
        boolean qL=false;
        boolean qR=false;
        if(root==p||root==q){
            return root;
        }
        if(find(root.left,p)){
            pL=true;
        }else{
            pR=true;
        }
        if(find(root.left,q)){
            qL=true;
        }else{
            qR=true;
        }
        if(qL&&pL){
            return nearAncestor(root.left,p,q);
        }
        if(qR&&pR){
            return  nearAncestor(root.right,p,q);
        }else{
            return root;
        }
    }


}
