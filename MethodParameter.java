import java.util.Arrays;
public class MethodParameter{
	public static void swap(int[]a,int[]b){
		int[]t=a;
		a=b;
		b=t;
	}
	public static void bubblleSort(int[]a){ 
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
		
	} 
	public static int[] copyOf(int[]a,int newLength){
		int[]ret=new int[newLength];
		int length=Math.min(a.length,newLength);
		for(int i=0;i<length;i++){
			ret[i]=a[i];
		}
		return ret;
    }
	public static void halfSort(int[]a,int b){
		int left=0;
		int right=a.length-1;
		while(left<=right){
			int mid=(left+right)/2;	
			if(b==a[mid]){
				System.out.println(b+"下标为"+mid);
				break;
			}else if(b<a[mid]){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(left>right)
		System.out.println("没找到");
	}
	public static void main(String[]args){
		// int[] arr1={1,2,3,4};
		// int[] arr2={9,3,4,2};
        // swap(arr1,arr2);
        // System.out.println(Arrays.toString(arr1));	
		// System.out.println(Arrays.toString(arr2));	
        // int[]arr3={2,4,1,7,5,9,8};
		// bubblleSort(arr3);
		// System.out.println(Arrays.toString(arr3));
		int[]arr4={1,2,4,5,6,7,8,9};
		// halfSort(arr4,11);
		System.out.println(Arrays.toString(copyOf(arr4,5)));
	}
}