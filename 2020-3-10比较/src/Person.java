/*
自定义类型要进行比较
    1. 需要实现Comparable接口中的compareTo方法--->自然排序的实现方式
    2. 实现比较器Comparator接口中的compare方法--->非自然排序的实现方式
 */
public class Person  implements Comparable<Person>{

    public String name;
    public String gender;
    public int age;
    public int ID;

    Person(String name, String gender, int age,int ID) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ID=ID;
    }

    @Override
    public int compareTo(Person o) {
        int ret=this.age-o.age;
        if(ret<0){
            return -1;
        }else if(ret>0){
            return  1;
        }else{
            return  0;
        }
    }
    @Override
    public String toString() {
        return name + "--" + gender + "--" + age + "--"+ID;
    }
    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if (o == null || !(o instanceof Person)) {
            return false;
        }
        Person p=(Person)o;
        return name==p.name &&gender.equals(p.gender) &&ID==p.ID;
    }

    public static void main(String[] args) {
        int a=3;
        Person p=new Person("成","男",21,1103);
        Person q=new Person("南","男",19,1100);
        Person o=p;
        System.out.println(p.equals(a));
        System.out.println(p.compareTo(q));
        System.out.println(p.equals(o));
    }
}
