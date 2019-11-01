import java.util.Scanner;

public class MethodDemo{
	public static double sub(double x,double y){
		return x-y;
	}
	public static void swap(int a,int b){
		int tmp=a;
		a=b;
		b=tmp;
	}
	public static int fac(int c){
		if(c==1){
			return 1;
		}
		else{
			return c*fac(c-1);
		} 
	}
	public static int sumFac(int d){
		int i;
		int sum=0;
		for(i=1;i<=d;i++){
			sum=sum+fac(i);
		}
		return sum;
	}
	public static int  Fibonnacci(int n){
		if(n==1||n==2){
			return 1;
		}
		else{
			return Fibonnacci(n-1)+Fibonnacci(n-2);
		}
		// int[] a=new int[n];
		// a[0]=1;
		// a[1]=1;
		// int i;
		// for(i=2;i<n;i++){
			// a[i]=a[i-1]+a[i-2];
		// }
		// return a[n-1];
			
		
	}
	public static void main(String[] args){
		//Scanner input=new Scanner(System.in);
		// double a=3.5;
		// double b=1.0;
		// double c=sub(a,b);
		// System.out.println("结果为："+c);
		// int  a=20;
		// int b=10;
		// swap(a,b);
		// System.out.println("a="+a);
		// System.out.println("b="+b);
		
		// System.out.println("输东西，快点的");
		// int n=input.nextInt();
		// int a=sumFac(n);
		// System.out.println(n+"的阶乘为："+a);
		int set=Fibonnacci(10);
		System.out.println(set);
	}
}