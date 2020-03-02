import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
    //给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
    //递归
    public static TreeNode increasingBST(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inorder(root,list);
        TreeNode newRoot=new TreeNode(0);
        TreeNode cur=newRoot;
        for (int val: list) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return newRoot.right;
    }
    public static void inorder(TreeNode root,List<Integer>list){
        if(root!=null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
        return ;
    }
    //改变树
    public static TreeNode cur;
    public static TreeNode increasingBST1(TreeNode root) {
            if(root==null){
                return root;
            }
            TreeNode nHead=new TreeNode(0);
            cur=nHead;
            helper(root);
            return nHead.right;
    }

    public  static void helper(TreeNode root){
        if(root!=null){
            helper(root.left);
            //1.左边已经为空
            //2.左边原本不为空 将根结点左边改为空 加入新树
            root.left=null;
            cur.right=root;
            cur=cur.right;
            helper(root.right);
        }
        return ;
    }
}
