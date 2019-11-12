import java.util.Arrays;
public class ArrayTurn{
	public static int[] myCopyOfRange(int[]a,int from,int to){
		int size=to-from;
		int[] dest=new int[size];
		for(int i=from;i< to;i++){
			dest[i-from]=a[i];
		}
		return dest;
	} 
	                             //被拷贝的  从哪开始拷  拷到    具体位置        长度   
	public static void myArrayCopy(int[]src,int srcPos,int[]dest,int destPos,int length){
		if(src==dest){
			int[]tmp=myCopyOfRange(src,srcPos,srcPos+length);
			for(int i=0;i<length;i++){
				dest[destPos+i]=tmp[i];
			}
		}else{
			for(int i=0;i<length;i++){
				dest[destPos+i]=src[srcPos+i];
			}
		}
	}
	public static int[] rightTurnArray(int[]dest,int turn){
		turn=turn%dest.length;
		int[] right=myCopyOfRange(dest,dest.length-turn,dest.length);
		myArrayCopy(dest,0,dest,turn,dest.length-turn);
		myArrayCopy(right,0,dest,0,turn);
		return dest;
	}
	public static int[] leftTurnArray(int[]dest,int turn){
		turn=turn%dest.length;
		int[] left=myCopyOfRange(dest,0,turn);
		myArrayCopy(dest,turn,dest,0,dest.length-turn);
		myArrayCopy(left,0,dest,dest.length-turn,turn);
		return dest;
	}
	public static void main(String[]args){
		int []a={1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(a));
		// myArrayCopy(a,2,a,6,4);
		// System.out.println(Arrays.toString(a));
		// int[]b={3,3,3,3,3};
		// System.out.println(Arrays.toString(b));
		// myArrayCopy(a,4,b,0,5);
		// System.out.println(Arrays.toString(b));
		rightTurnArray(a,3);
		System.out.println(Arrays.toString(a));
		int []e={1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(e));
		int []d=leftTurnArray(e,13);
		System.out.println(Arrays.toString(d));
	}
}