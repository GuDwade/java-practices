import java.util.Queue;
import java.util.Stack;

public class MyQueueByStack {
    Stack<Integer> sta1;
    Stack<Integer> sta2;
    public MyQueueByStack(){
        sta1=new Stack<>();
        sta2=new Stack<>();
    }

    public void push(int x) {
            sta1.push(x);
    }

    public int pop(){
        if(sta2.isEmpty()){
            int sz= sta1.size();
            for(int i=0;i<sz;++i) {
                sta2.push(sta1.pop());
            }
        }
        return sta2.pop();
    }

    public int peek(){
        if(sta2.isEmpty()){
            int sz= sta1.size();
            for(int i=0;i<sz;++i) {
                sta2.push(sta1.pop());
            }
        }
        return sta2.peek();
    }

    public  boolean empty(){
        return sta1.isEmpty()&&sta2.isEmpty();
    }
}
