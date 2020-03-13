import java.util.Arrays;

public class Template <E>{
}

class MyArrayList<E>{
    private E[]array;
    int size;
    int cap;

    MyArrayList(){
        // 泛型类型无法直接创建数组 强转
        array=(E[])new Object[10];
        size=0;
        cap=10;
    }

    public void add(E e){
        if(size==cap){
            array=Arrays.copyOf(array,2*cap);
            cap=2*cap;
        }
        array[size++]=e;
    }

    public E remove(){
        if(size>0){
            E e=array[size-1];
            array[size-1]=null;
            size--;
            return  e;
        }else{
            return null;
        }
    }

}
class MyLinkList<E>{
    //静态成员不能定义泛型: 属性和函数
    //private static E e;
    //非静态内部内可以使用外部类的泛型参数
    //静态内部类不能使用外部类的泛型参数，需要自己定义
    public static class Node<E> {
        private E value;
        private Node<E> next;
        private Node(E e) {
            value = e;
            next = null;
        }
    }

    private Node<E> head;
    private int size;
    MyLinkList(){
        head=null;
        size=0;
    }

    public void pushFront(E e) {
        Node node=new Node(e);
        node.next=head;
        head=node;
        size++;
    }

    public void pushBack(E e) {
        if(size==0){
            head=new Node<>(e);
            size++;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=new Node(e);
        size++;
    }

    public static void fun1(MyLinkList<?>  ml)
    {

    }
    // ? extends 类型： 指明类型的上界
    public static void fun2(MyLinkList <? extends Integer> m1)
    {

    }

    //? super 类型： 指明类型的下界， 最低要求
    public static void fun3(MyLinkList <? super Number> m1){

    }
}
class A implements Comparable<A>{
    @Override
    public int compareTo(A o) {
        return 0;
    }
}

class C{

}

class B<E extends Comparable<E>, T>{
    public static void main(String[] args) {
        B<Integer, Character> b = new B<>();
       // B<C, Character> c = new B<>(); 错误
        B<A, Character> d = new B<>();
    }
}