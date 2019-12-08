import java.util.Stack;

public class MinStack {
     public Stack<Integer>stack;
     public Stack<Integer>minstack;

    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty()){
            minstack.push(x);
        }else if(stack.peek()<=minstack.peek()){
            minstack.push(x);
        }
    }

    public void pop() {
        if(stack.peek()==minstack.pop()){
            minstack.peek();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minstack.peek();
    }
}

