public class IsUnivalTree {
    //单值二叉树
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left!=null&&root.left.val!=root.val){
            return  false;
        }
        if(root.right!=null&&root.right.val!=root.val){
            return  false;
        }
        return isUnivalTree(root.left)&&isUnivalTree(root.right);
    }
    //反转二叉树
    //前序
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode right=root.right;
        root.right=invertTree(root.left);
        root.left=invertTree(right);
        return root;
    }
    //中序
    public TreeNode invertTreeOrder(TreeNode root){
        if(root==null){
            return null;
        }
        invertTreeOrder(root.left);
        TreeNode right=root.right;
        root.right=root.left;
        root.left=invertTreeOrder(right);
        return root;
    }
}
