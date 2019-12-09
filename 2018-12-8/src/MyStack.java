import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> que;
    public MyStack() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.offer(x);
    }

    public int pop() {
        int sz = que.size();
        while(sz > 1) {
            que.offer(que.poll());
            --sz;
        }
        return que.poll();
    }

    public int top() {
        int sz = que.size();
        while(sz > 1) {
            que.offer(que.poll());
            --sz;
        }
        int ret = que.poll();
        que.offer(ret);
        return ret;
    }

    public boolean empty() {
        return que.isEmpty();
    }

}
