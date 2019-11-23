import java.util.Arrays;
public class ArrayContinue{
	public static int[] copyOfRange(int[]a,int from,int to){
		int size=to-from;
		int[]ret=new int[size];
		// for(int i=0;i<size;i++){
			// ret[i]=a[from];
			// from++;
		// }
		for(int i=from;i<to;i++){
			ret[i-from]=a[i];
		}
		return ret;
	}
	public static int[]fillArray(int[ ]a,int v){
		for(int i=0;i<a.length;i++){
			 a[i]=v;
		}
		return a;
	}
	public static void main(String[]args){
		int[] arr={1,2,3,4,5,6,7,8,};
		System.out.println(Arrays.toString(copyOfRange(arr,1,5)));
	}
} 