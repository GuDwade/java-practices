class Solution {
    static int curIdx=0;
    public TreeNode _buildTree(int[]pre,int[]in,int inS,int inE){
        if(inS>inE){
            return null;
        }
        int rootValue=pre[curIdx];
        curIdx++;
        TreeNode root=new TreeNode(rootValue);
        if(inS==inE){
            return root;
        }
        int i;
        for(i=inS;i<=inE;++i){
            if(in[i]==rootValue){
                break;
            }
        }
        root.left=_buildTree(pre,in,inS,i-1);
        root.right=_buildTree(pre,in,i+1,inE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIdx=0;
        return _buildTree(preorder,inorder,0,preorder.length-1);
    }
}
