public class Test {
    static TreeNode prev = null;
    public void _Convert(TreeNode root){
        if(root == null)
            return;

        _Convert(root.left);
        root.left = prev;
        if(prev != null)
            prev.right = root;
        prev = root;
        _Convert(root.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;

        prev = null;
        _Convert(pRootOfTree);

        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
}


