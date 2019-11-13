import java.util.Arrays;
public class MyArrayList{
	private int[]array;
	private int size;
	public MyArrayList(){
		array=new int[10];
		size=0;
	}
	//时间复杂度 空间复杂度都为O（1）
	public void pushBack(int element){
		// array[size]=element;
		// size++;
		array[size++]=element;
	}
	public void popBack(){
		// array[size-1]=0;
		// size--;
		array[--size]=0;
	}
	public void pushFront(int element){
		// for(int i=size-1;i>=0,i--){
			// array[i+1]=array[i];
		// }
		// array[0]=element;
		// size++;
		System.arraycopy(array,0,array,1,size);
		// for(int i=size;i>0;i--){
			// array[i]=array[i-1];
		// }
		array[0]=element;
		size++;
	}
	public void popFront(){
		// System.arraycopy(array,1,array,0,size-1);
		for(int i=0;i<size;i++){
			array[i]=array[i+1];
		}
		array[--size]=0;
	}
	public void insert(int index,int element){
		for(int i=size;i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=element;
		size++;
	}
	public void delete(int index){
		for(int i=index;i<size;i++){
			array[i]=array[i+1]; 
		}
		array[--size]=0; 
	}
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	public static void main(String[]args){
		MyArrayList list=new MyArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		System.out.println(list);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		System.out.println(list);
		list.popFront();
		list.popFront();
		System.out.println(list);
		list.insert(2,55);
		System.out.println(list);
		list.delete(2);
		System.out.println(list);
	}
}