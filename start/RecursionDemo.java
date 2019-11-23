public class RecursionDemo{
	public static void printfNumber(int n){
		if(n<10){
			System.out.printf("%d ",n);
		}
		else{
			int a=n/10;
			printfNumber(a);
			int b=n%10;
			System.out.printf("%d ",b);
		}
	}
	public static int plusNumber(int x){
		if(x<10){
			return x;
		}
		else{
			int a=x%10;
			return a+plusNumber(x/10);
		}
	}
	public static void printfMove(char a,char c){
		System.out.println("从"+a+"移动到"+c);
	}                                 //原始 借助    目的
	public static void hannuota(int x,char A,char B,char C){
		if(x==1){
			printfMove(A,C);
		}
		else{
			hannuota(x-1,A,C,B);
			printfMove(A,C);
			hannuota(x-1,B,A,C);
		}
	}
	public static int frogJump(int x){
		if(x==0||x==1){
			return 1;
		}
		else{
			return frogJump(x-1)+(x-2);
		}
		
	}
	public static void main(String[]args){
		// printfNumber(211);
		//int y=plusNumber(9527);
		// System.out.printf("%d ",y);
		//hannuota(4,'A','B','C');
		int x=frogJump(10);
		System.out.println("青蛙有"+x+"方法");
	}
}