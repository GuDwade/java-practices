import java.util.Objects;

class  A{
    String name;
    int age;

    // idea自动生成equals方法和hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        A a = (A) o;
        return age == a.age &&
                name.equals(a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public A(String name, int age){
        this.name = name;
        this.age = age;

    }
}
// K类型： 必须要重写两个函数： equals, hashCode
//     Object父类的默认实现不符合要求
//     如果equals相等，必须保证hashCode返回值必须相同， 但是反过来不一定，因为有哈希冲突
public class HashBucketT<K,V> {
    private static class Node<K,V>{
        private Node<K,V> next;
        private K key;
        private V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node<K,V>[]  array;
    private int size;

    public HashBucketT(){
        array = (Node<K, V>[]) new Node[10];
        size = 0;
    }

    public V get(K key){
        //int idx = key % array.length;  // key 为引用
        int idx = key.hashCode() % array.length;  //用hashCode
        Node<K,V> cur = array[idx];
        while(cur != null){
            //if(cur.key == key){
            if(cur.key.equals(key)){  //用equals
                return cur.value;
            }
            cur = cur.next;
        }
        return null;

    }

    public static void main(String[] args) {
        //HashBucketT<A, A> hb;
        A a1 = new A("0", 10);
        A a2 = new A("0", 10);
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));

    }
}
