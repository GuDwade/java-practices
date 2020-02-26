import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Iteration {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        TreeNode curNode=root;
        while(curNode!=null||!stack.isEmpty()){
            while(curNode!=null){
                ret.add(curNode.val);
                stack.push(curNode);
                curNode=curNode.left;
            }
            //出循环左结点为空 指向栈顶元素（当前结点的根结点）的右边
            curNode=stack.pop().right;
        }
        return ret;
    }
    //
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        TreeNode curNode=root;
        while(curNode!=null||!stack.isEmpty()){
            while(curNode!=null){
                //先访问左子树
                stack.push(curNode);
                curNode=curNode.left;
            }
            //再访问根
            curNode=stack.pop();
            ret.add(curNode.val);
            curNode=curNode.right;
        }
        return ret;
    }
    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        TreeNode curNode=root;
        TreeNode prev=null;
        while(curNode!=null||!stack.isEmpty()){
            while(curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }
            curNode=stack.peek();
            //右树为空 或者右结点已经出栈  才能访问根节点
            if(curNode.right==null||curNode.right==prev){
                ret.add(curNode.val);
                prev=curNode;
                stack.pop();
                curNode=null;
            }else {
                curNode=curNode.right;
            }
        }
        return ret;
    }
}
