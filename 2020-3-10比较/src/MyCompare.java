import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int ret = o1.age - o2.age;
        if(ret < 0)
            return -1;
        else if(ret > 0)
            return 1;
        else
            return 0;
    }
}
class PersonIDComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.ID-o2.ID;
    }
}
class IntegerComparator1 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
class IntegerComparator2 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
public class MyCompare {
    public static void bubbleSort(Person[]personArray){
        int len=personArray.length;
        while(len>0){
            boolean flag=true;
            for(int i=0;i<len-1;i++){
                //自然排序
                if(personArray[i].compareTo(personArray[i+1])>0){
                    Person p=personArray[i+1];
                    personArray[i+1]=personArray[i];
                    personArray[i]=p;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
            len--;
        }
    }
    public static void bubbleSort1(Person[]personArray,PersonAgeComparator comparator){
        int len=personArray.length;
        while(len>0){
            boolean flag=true;
            for(int i=0;i<len-1;i++){
                //比较器
                if(comparator.compare(personArray[i],personArray[i+1])>0){
                    Person p=personArray[i+1];
                    personArray[i+1]=personArray[i];
                    personArray[i]=p;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
            len--;
        }
    }
    public static void main(String[] args) {
        Person[]personArray={new Person("成","男",21,1103),
                new Person("琴","女",25,1102),
                new Person("星","女",17,1104),
                new Person("翔哥","男",9,1101)};
        Person[]copy=personArray.clone();
        /*
        Arrays.sort(personArray);
        System.out.println(Arrays.toString(personArray));
        */
        Arrays.sort(personArray,new PersonAgeComparator());
        System.out.println(Arrays.toString(personArray));
        Arrays.sort(personArray,new PersonIDComparator());
        System.out.println(Arrays.toString(personArray));
        Person p=new Person("成","男",21,1103);
        Person q=new Person("成","男",21,1103);
        Person o=new Person("成","女",21,1103);
        System.out.println(p.equals(q));
        System.out.println(p.equals(o));
        //优先队列
        //PriorityQueue<Integer> pq=new PriorityQueue<>();
        //PriorityQueue<Integer> pq=new PriorityQueue<>(new IntegerComparator1());
        PriorityQueue<Integer> pq=new PriorityQueue<>(new IntegerComparator2());
        //尾插 向上调整
        pq.offer(10);
        pq.offer(4);
        pq.offer(11);
        pq.offer(5);
        pq.offer(9);
        pq.offer(23);
        pq.offer(34);
        pq.offer(3);
        while(!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
        System.out.println();
        //冒泡排序
        System.out.println("冒泡排序:");
        //bubbleSort(copy);
        bubbleSort1(copy,new PersonAgeComparator());
        System.out.println(Arrays.toString(copy));

    }
}


