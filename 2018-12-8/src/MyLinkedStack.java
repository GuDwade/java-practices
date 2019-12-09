import java.util.Arrays;

public class MyLinkedStack {
     public int[]array;
     public int size;

     MyLinkedStack(int n){
         array=new int[n];
         size=0;
     }

     public  void push(int val){
         if(size==array.length){
             array=Arrays.copyOf(array,2*size);
         }
         array[size++]=val;
     }

     public void pop(){
        if(size>0){
            array[--size]=0;
        }
     }

     public int peek(){
         return array[size-1];
     }

     public boolean isEmpty(){
         return size==0;
     }

    public static void main(String[] args) {
        MyLinkedStack sta=new MyLinkedStack(3);
        sta.push(1);
        sta.push(2);
        sta.push(3);
        System.out.println(sta.array.length);
        sta.push(4);
        System.out.println(sta.array.length);
        System.out.println(sta.peek());
        sta.pop();
        System.out.println(Arrays.toString(sta.array));
        sta.pop();
        sta.pop();
        System.out.println(sta.isEmpty());
        sta.pop();
        System.out.println(sta.isEmpty());
        sta.pop();
        System.out.println(sta.isEmpty());

    }
}


