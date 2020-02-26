import java.util.Stack;

public class ValidBST {
    //按照二叉搜索树的性质中序遍历 判断栈顶元素大小
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        Stack<Integer>ret=new Stack<>();
        if(root==null){
            return true;
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
            if(ret.isEmpty()){
                ret.add(curNode.val);
            }else if(ret.peek()<curNode.val){
                ret.add(curNode.val);
            }else {
                return  false;
            }
            curNode=curNode.right;
        }
        return true;
    }
    //用一个数字来比较
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        int prev=Integer.MIN_VALUE;
        if(root==null){
            return true;
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
            if(prev<curNode.val){
                prev=curNode.val;
            }else{
                return  false;
            }
            curNode=curNode.right;
        }
        return true;
    }
}
