public class MyCircularQueue {
    public int[]array;
    public int size;
    public int front;
    public int rear;
    MyCircularQueue(int n){
         array=new int[n+1];
         size=0;
         front=0;
         rear=0;
    }

    public boolean enQueue(int value) {
      if(!isFull()){
          array[rear]=value;
          rear=(rear+1)%array.length;
          if(size<array.length){
              size++;
          }
          return true;
      }else
          return false;
    }


    public boolean deQueue() {
        if(!isEmpty()){
         front=(front+1)%array.length;
         if(size>0){
             size--;
         }
         return true;
        }else
            return  false;
    }


    public int Front() {
        if(!isEmpty()){
            return array[front];
        }else
            return  -1;
    }

    public int Rear() {
        if(!isEmpty()){
            return array[rear];
        }else
            return  -1;
    }


    public boolean isEmpty() {
        return (rear+1)%array.length!=front;
    }


    public boolean isFull() {
        return (rear+1)%array.length==front;
    }
}
