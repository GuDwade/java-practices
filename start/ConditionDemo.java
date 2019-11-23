public class ConditionDemo{
	public static void main(String[] args){
		/*if(1)//if(布尔表达式){
		System.out.println("true");
		}
		else{
		System.out.println("false");
		}*/
		/*
		int n=Integer.parseInt(args[0]);
		if(n%2!=0){
			System.out.println(n+"是奇数");
		}
		else{
			System.out.println(n+"是偶数");
		}
		*/
		/*
		int year =Integer.parseInt(args[0]);
		if(year%400==0||(year%4==0&&year%100!=0)){
			System.out.println(year+"年是闰年");
		}
		else{
			System.out.println(year+"年不是闰年");
		}
		*/
		//if(1==20);//语句结束{
			//System.out.println("不可能")；
		//}
		/*String s=args[0];
		switch(s){
			case "gufucheng":
			   System.out.println("海波爸爸");
			   break;
			case "weihaibo":
			   System.out.println("顾哥儿子");
			   break;
			default :
			   System.out.println("海波哈哈哈");
			   break;
		}
		*/
		/*
		int today=Integer.parseInt(args[0]);
		switch(today){
			case 1:
			 System.out.println("星期一");
			 break;
			case 2:
			 System.out.println("星期二");
			 break;
			case 3:
			System.out.println("星期三");
			 break;
			case 4:
			System.out.println("星期四");
			 break;
			 case 5:
			System.out.println("星期五");
			 break;
			 case 6:
			System.out.println("星期六");
			 break;
			 case 7:
			System.out.println("星期天");
			 break;
			default:
			System.out.println("输入错误");
			 break;
		}
         */	
		
		int today=Integer.parseInt(args[0]);
		switch(today){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("上班");
				break;//注意break
			case 6:
			case 7:
				System.out.println("睡觉");
				break;
			default:
				System.out.println("输入错误");
				break;
		}
		
		
		
	}
}