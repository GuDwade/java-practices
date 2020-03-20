public class HashBucket {
    private static class Node{
        int key;
        int value;
        Node next = null;
        public Node(int key, int value)
        {
            this.key  = key;
            this.value = value;
            next = null;
        }
    }

    private Node[] array;
    private int size;
    private static final double LOAD_FACTORY = 0.7;

    public HashBucket()
    {
        array = new Node[10];
        size = 0;
    }

    //负载因子
    public double loadFactory(){
        return size * 1.0 / array.length;
    }

    public int put(int key, int value){
        //检查容量
        if(loadFactory() >= LOAD_FACTORY){
            //增容
            resize();
        }
        //插入
        // 1. 计算哈希值
        int idx = key % array.length;
        // 2. 不能插入重复的key, 首先要查看key是否已经存在, 遍历当前位置的单链表
        Node cur = array[idx];
        while(cur != null){
            if(cur.key == key){
                int oldV = cur.value;
                cur.value = value;
                return oldV;
            }
            cur = cur.next;
        }
        // 3. 插入： 单链表的头插
        cur = new Node(key, value);
        cur.next = array[idx];
        array[idx] = cur;

        ++size;
        return -1;
    }
    public void resize(){
        Node[]newArray=new Node[array.length*2];
        //元素搬移       长度变化  idx改变  不能简单复制
        for(int i=0;i<array.length;i++){
            Node curHead=array[i];
            while(curHead!=null){
                Node next=curHead.next;
                //头插
                int idx=curHead.key%newArray.length;
                curHead.next=newArray[idx];
                newArray[idx]=curHead;
                curHead=next;
            }
        }
        array=newArray;
    }
    public int get(int key){
        int idx=key%array.length;
        Node cur=array[idx];

        while(cur!=null){
            if(cur.key==key){
                return  cur.value;
            }
            cur=cur.next;
        }
        return -1;
    }

    public int remove(int key){
        int idx=key%array.length;
        Node prev=null;
        Node cur=array[idx];
        while(cur!=null){
            if(cur.key==key){
                if(prev==null){
                    array[idx]=cur.next;
                }else {
                    prev.next=cur.next;
                }
                return cur.value;
            }
            prev=cur;
            cur=cur.next;
        }
        return  -1;
    }
}
