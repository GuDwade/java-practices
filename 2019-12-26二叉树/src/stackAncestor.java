import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
  }
public class stackAncestor {
    public boolean getPath(TreeNode root,TreeNode node,Stack<TreeNode> st) {

        if (root == null)
            return false;
        //root入栈
        st.push(root);
        if (root == node)
            return true;  //结束        }
        //判断左右子树是否存在node
        if (getPath(root.left, node, st))
            return true;
        if (getPath(root.right, node, st))
            return true;
        st.pop();   //当前节点出栈

        return false;
    }
    //public TreeNode lowestCommonAncestor2(TreeNode root,)
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        Stack<TreeNode> path1=new Stack<>();
        Stack<TreeNode> path2=new Stack<>();
        getPath(root,p,path1);
        getPath(root,q,path2);
        //裁剪路径
        while(path1.size()!=path2.size()) {
            if (path1.size() > path2.size())
                path1.pop();
            else
                path2.pop();

        }
        //匹配
        while(path1.size()!=0){
            if(path1.peek()==path2.peek()){
                break;
            }else{
                // if(path1.peek()==path2.peek()){
                path1.pop();
                //  }else{
                path2.pop();

            }
        }
        return path1.peek();
    }

}