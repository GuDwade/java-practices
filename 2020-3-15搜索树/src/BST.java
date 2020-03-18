class  Person implements  Comparable<Person>{
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    @Override
    public int compareTo(Person o) {
        int ret=this.age-o.age;
        if(ret<0){
            return -1;
        }else if(ret>0){
            return  1;
        }else{
            return  0;
        }
    }
    @Override
    public String toString(){
         return String.format("[%s %d]",name,age);
    }


}
public class BST<K extends Comparable<K>, V> {
    private  static  class MyEntry<K,V>{
        K key;
        V value;
        MyEntry<K,V>left;
        MyEntry<K,V>right;

        public MyEntry(K key,V val){
            this.key=key;
            this.value=val;
            left=right=null;
        }
    }

    private  MyEntry<K,V>root=null;
    private int size=0;


    public V get(K key){
        if(root==null){
            return  null;
        }
        MyEntry<K,V>cur=root;
        while(cur!=null){
            int r=cur.key.compareTo(key);
            if(r==0){
                return  cur.value;
            }else if(r>0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }

    public V put(K key, V value){
        if(root==null){
            root=new MyEntry<>(key,value);
            size++;
            return  null;
        }
        MyEntry<K,V>cur=root;
        MyEntry<K,V>parent=null;
        while(cur!=null){
            parent=cur;
            int diff=cur.key.compareTo(key);
            if(diff==0){
                V oldVal=cur.value;
                cur.value=value;
                return  oldVal;
            }else if(diff>0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        cur=new MyEntry<>(key,value);
        int diff=parent.key.compareTo(key);
        if(diff>0){
            parent.left=cur;
        }else {
            parent.right=cur;
        }
        size++;
        return  null;
    }

    public V remove(K key){
        if(root==null){
            return null;
        }
        MyEntry<K,V>cur=root;
        MyEntry<K,V>parent=null;
        while(cur!=null){
            int diff=cur.key.compareTo(key);
            if(diff==0){
                break;
            }else if(diff>0){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        if(cur==null){
            return  null;
        }
        V oldVal=cur.value;
        remove(parent,cur);
        size--;
        return  oldVal;
    }

    private void remove(MyEntry<K,V> parent, MyEntry<K,V> cur){
        if(cur.left==null){
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.right;
                }else{
                    parent.right=cur.right;
                }
            }
            root=cur.right;
        }else if(cur.right==null){
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }
            root=root.left;
        }else{
            /*左子树的最右结点
            parent=cur;
            MyEntry<K,V>next=cur.left;
            while(next.right!=null){
                parent=next;
                next=cur.right;
            }
            cur.key=next.key;
            cur.value=next.value;
            if(parent.left==next){
                parent.left=next.left;
            }else{
                parent.right=next.left;
            }
            */
          //  右子树的最左结点
            parent=cur;
            MyEntry<K,V>next=cur.right;
            while(next.left!=null){
                parent=next;
                next=next.left;
            }
            cur.key=next.key;
            cur.value=next.value;
            if(parent.left==next){
                parent.left=next.right;
            }else{
                parent.right=next.right;
            }
        }
    }

    public void inOrder(){
        inOrderInternal(root);
        System.out.println();
    }

    private void inOrderInternal(MyEntry<K, V> root){
        if(root != null){
            inOrderInternal(root.left);
            System.out.print(root.key + "--->"  + root.value + " ");
            inOrderInternal(root.right);
        }
    }

    public  static void test(){
        BST<Character,Integer>bst=new BST<>();
        Integer a=bst.put('a',4);
        System.out.println(a);
        Integer b=bst.put('a',5);
        System.out.println(b);
        Integer c=bst.get('a');
        System.out.println(c);
        bst.put('g',2);
        bst.put('d',5);
        bst.put('j',0);
        bst.put('e',5);
        bst.put('b',7);
        bst.put('r',3);
        bst.inOrder();
    }
    public  static void test1(){
        BST<Person,Integer> per=new BST<>();
        per.put(new Person("顾富成",20),10);
        per.put(new Person("小布",12),45);
        per.put(new Person("阿威",6),67);
        per.put(new Person("李白",34),30);
        per.put(new Person("老子",78),89);
        per.put(new Person("孙子",26),67);
        per.inOrder();
        per.remove(new Person("顾富成",20));
        per.inOrder();
        System.out.println(per.root.key+"----"+per.root.value);

    }
    public static void main(String[] args) {
         //test();
        test1();
    }
}
