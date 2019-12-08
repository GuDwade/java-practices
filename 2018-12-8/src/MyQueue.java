public class MyQueue {
      public Node head=null;
      public Node tail=null;
      int size=0;

      public void offer(int val) {
         Node node = new Node(val);
         if (tail == null) {
            head = node;
         } else {
            tail.next = node;
         }
         tail=node;
         size++;
      }

      public int poll(){
         if(size==0){
            throw new RuntimeException("队列为空");
         }
         Node oldHead=head;
         head=head.next;
         if(head==null){
            tail=null;
         }
         size--;
         return oldHead.val;
      }

      public int peek(){
         if(size==0){
            throw new RuntimeException("队列为空");
         }
         return head.val;
      }

      public int size(){
          return size;
      }
      public boolean isEmpty(){
          return size==0;
      }

    public static void main(String[] args) {
        MyQueue que=new MyQueue();
        que.offer(1);
        que.offer(2);
        que.offer(3);
        que.offer(4);
        while(!que.isEmpty()){
            System.out.println(que.peek());
            que.poll();
        }
        System.out.println(que.isEmpty());
        System.out.println(que.size);
    }
}