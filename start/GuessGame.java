import java.util.Scanner;
import java.util.Random;


public class GuessGame{
	public static void menu(){
				System.out.println("******************");
				System.out.println("*****1.  play ****");
				System.out.println("*****0.  exit ****");
				System.out.println("******************");
			}
	public static void difficulty(){
				System.out.println("*******请选择困难度******");
				System.out.println("*****1.简单(十次机会)****");
				System.out.println("*****2.中等(八次机会)****");
				System.out.println("*****3.困难(五次机会)****");
			}		
    public static void game(int dtimes){
		    Random random=new Random();
			System.out.println("欢迎进入游戏，正在为您生成随机数中....");
			Scanner scanner=new Scanner(System.in);
			int n=random.nextInt(100);
			System.out.println("随机数已生成，请开始游戏");
			int times=dtimes;
			int i=0;
			for(i=1;i<=times;i++){
				int x=scanner.nextInt();
				if(x==n){
					System.out.println("测试成功了，用了"+i+"次机会");
					break;
				}else if(x<n){
					System.out.println("第"+i+"次猜测，猜小了");
				}else{
					System.out.println("第"+i+"次猜测，猜大了");
				}
			}
			
			if(i>times){
			System.out.println("很遗憾，Gameover");
			System.out.println("数字是"+n);
			}
	}
	public static void main(String[] args ){
		boolean flag=true;
		do{
			menu();
			System.out.println("请选择");
			Scanner input=new Scanner(System.in);
			int j=input.nextInt();
			switch(j){
				case 1:
				    difficulty();
					int dif=input.nextInt();
					switch(dif){
						case 1:
							game(10);
							break;
						case 2:
							game(8);
							break;
						case 3:
							game(5);
							break;
						default	:
							System.out.println("输入错误，请重新输入");
							break;
					}
					
					break;
				case 0:
					System.out.println("退出游戏");
					flag=false;
					break;
				default:
					System.out.println("输入错误，请重新输入");
					break;	
			}
		}while(flag);
			
	}
}