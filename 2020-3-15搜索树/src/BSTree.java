public class BSTree {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            right = left = null;
        }
    }
    private Node root = null;
    //寻找
    public Node find(int value){
        if(root==null){
            return null;
        }
        Node cur=root;
        if(cur.value==value){
            return root;
        }else if(cur.value>value){
            cur=cur.left;
        }else {
            cur=cur.right;
        }
        return null;
    }
    //插入
    public boolean insert(int value){
        if(root==null){
            root=new Node(value);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            parent=cur;
            if(cur.value==value){
                return false;
            }else if(cur.value>value){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        cur=new Node(value);
        if(parent.value>value){
            parent.left=cur;
        }else{
            parent.right=cur;
        }
        return true;
    }

    public boolean remove(int value){
        if(root==null){
            return  false;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.value==value){
                break;
            }else if(cur.value>value){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        if(cur==null){
            return false;
        }
        removeNode(parent,cur);
        return  true;
    }

    public void removeNode(Node parent, Node cur){
        if(cur.left==null){
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.right;
                }else{
                    parent.right=cur.right;
                }
            }else{
                root=cur.right;
            }
        }else if(cur.right==null){
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }else{
                root=cur.left;
            }
        }else{
            //左右子树都存在
            // 1. 找到左子树的最右节点
            // 2. 或者找到右子树的最左节点
            parent=cur;
            Node next=cur.left;
            while(next.right!=null){
                parent=next;
                next=next.right;
            }
            cur.value=next.value;
            if(parent.left==next){
                parent.left=next.left;
            }else{
                parent.right=next.left;
            }
        }
    }
    //中序遍历
    public void inOrder(){
        inOrderInternal(root);
        System.out.println();
    }

    public void inOrderInternal(Node root){
        //中序遍历
        if(root != null){
            inOrderInternal(root.left);
            System.out.print(root.value + " ");
            inOrderInternal(root.right);
        }
    }

    public static void main(String[] args) {
        BSTree bst=new BSTree();
        bst.insert(10);
        bst.insert(17);
        bst.insert(6);
        bst.insert(11);
        bst.insert(2);
        bst.insert(7);
        bst.insert(5);
        bst.inOrder();

        bst.remove(10);
        bst.inOrder();

        bst.remove(7);
        bst.inOrder();
    }
}
