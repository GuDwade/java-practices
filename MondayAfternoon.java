import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class MondayAfternoon{
	public static int halfSort(int[]arr,int sea){
		int left=0;
		int right=arr.length-1;
		//左闭右开，区间内还有数字
		while(left<right){
			int mid=(left+right)/2;
			if(arr[mid]==sea){
				return mid;
			}else if(arr[mid]<sea){
				left=mid+1;
			}else{
				right=mid;
			}
		}
		return -1;
	}
	public static int myHalfSort(int[]arr,int sea){
		int left=0;
		int right=arr.length;
		//左闭右闭，区间内还有数字
		while(left<=right){
			int mid=(left+right)/2;
			if(arr[mid]==sea){
				return mid;
			}else if(arr[mid]<sea){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		return -1;
	}
	public static int[] myCopyOf(int[]a,int newSize){
		int[]dest=new int[newSize];
		int length=newSize<a.length?newSize:a.length;
		for(int i=0;i<length;i++){
			dest[i]=a[i];
		}
		return dest;
	}
	public static void fillArray(){
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		int size=rand.nextInt(10);
		int[]a=new int[size];
		System.out.println("数组长度为："+size);
		for(int i=0;i<a.length;i++){
			a[i]=scan.nextInt();
		}
		System.out.println(Arrays.toString(a));
	}
	public static int[] myCopyOfRange(int[]a,int from,int to){
		//左闭右开
		int size=to-from;
		int[] dest=new int[size];
		for(int i=from;i< to;i++){
			dest[i-from]=a[i];
		}
		// for(int i=0;i<size;i++){
			// dest[i]=a[from];
			// from++;
		// }
		return dest;
	}
	public static boolean equals(in[]a,int[]b){
		if(a.length!=b.length){
			return false;
		}
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				return false
			}
		}
		return true; 
	}
	public static void main(String[]args){
		int[]a={1,2,3,4,5,6,7,8,9,10};
		// int search=3;
		// System.out.println(Arrays.toString(a));
		// System.out.println(search+"的坐标是"+myHalfSort(a,search));
		// int[]b=myCopyOf(a,7);
		// System.out.println(Arrays.toString(b));
		// int[]c=myCopyOf(a,13);
		// System.out.println(Arrays.toString(c));
		// fillArray();
		int[]d=myCopyOfRange(a,2,9);
		System.out.println(Arrays.toString(d));
	}
}