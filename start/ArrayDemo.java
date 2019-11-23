import java.util.Arrays;


public class ArrayDemo{
	public static int maxArray(int[]a){
		int max=a[0];
		for(int i=1;i<a.length;i++){
			if(max<a[i]){
				max=a[i];
			}
		}
		return max;
	}
	public  static double aveArray(int[]a ){
        int sum=0;
		for(int v:a){
			 sum+=v;
		}
		return sum/a.length;
	}
	public static int indexArray(int x,int[]a){
	int i;
	for(i=0;i<a.length;i++){
		if(a[i]==x){
		   break;
		}
	}
    return i;
}
	public static int lastIndexArray(int x,int[]a){
	int i;
    int index=0;
	for(i=0;i<a.length;i++){
		if(a[i]==x){
			index=i;
		}
		
	}
    return index;
}
    public static int[] copyArray(int[]a,int from,int to){	
		int[] b=new int[to-from];
		for(int i=from;i<to;i++){
			b[i-from]=a[i];
		}
		return b;
}
    public static void swap(int[]a){
		int tmp=a[0];
		a[0]=a[1];
		a[1]=tmp;
		
	}
	public static void main(String[] args){
	// int []a={1,2,3}; 
	//int []a=new int[]{1,2,3};
    // for(int v: a){
	// System.out.println(v);
	// }
	// System.out.println(Arrays.toString(a));
	// int[] a={8,11,22,4,5,66,7,4};
	// int b=maxArray(a);
	// System.out.println("max="+b);
    // System.out.println("ave="+aveArray(a));
    // System.out.println("最初下标是"+indexArray(4,a));
	// System.out.println("最后下标是"+lastIndexArray(4,a));
    // System.out.println(Arrays.toString(a));	
	int[] b={33,15};
	System.out.println(Arrays.toString(b));	
	swap(b);
	System.out.println(Arrays.toString(b));	
	}
}