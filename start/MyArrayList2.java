import java.util.Arrays;
public class MyArrayList2{
	private int[]array;
	private int size;
	public MyArrayList2(int capacity){
		array=new int[capacity];
		size=0;
	}
	public MyArrayList2(){
		this(10); 
	}
	
	//时间复杂度 空间复杂度都为O（1）
	public void pushBack(int element){//尾插
		insert(size,element);
	}
	public void popBack(){//尾删
		delete(size-1);
	}
	public void pushFront(int element){//头插
		insert(0,element);
	}
	public void popFront(){//头删
		delete(0);
	}
	public void insert(int index,int element){
		if(index<0||index>size){
			throw newArrayIndexOutOfBoundsException(index);
		}
		boolean r=checkCapcity(1);
		if(!r){
			ensureCapcity();
		}
		for(int i=size;i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=element;
		size++;
	}
	public void delete(int index){
		if(size==0){
			System.out.println("空");
			return;
		}
		for(int i=index;i<size;i++){
			array[i]=array[i+1]; 
		}
		array[--size]=0; 
	}
	private boolean checkCapcity(int num){
		return size+num<=array.length;
	}
	private void ensureCapcity(){
		/*
		int newLength=size*2;
		int[]newArray=new int[newLength];
		for(int i=0;i<size;i++){
			newArray[i]=array[i];
		}
		this.array=newArray;
     */
	 array=Arrays.copyOf(array,array.length*2);		
	}
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	public static void main(String[]args){
		MyArrayList2 list=new MyArrayList2();
		list.pushFront(1);
		list.pushBack(2); 
		list.insert(1,3);
		list.insert(2,4);
		System.out.println(list);
		list.popFront();
		System.out.println(list);
		list.popBack();
		System.out.println(list);
	}
}