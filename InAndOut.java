import java.util.Scanner;

public class InAndOut{
	public static void main(String[] args){
			// Scanner scanner=new Scanner(System.in);
			// while (scanner.hasNext()) {
			    //String s = scanner.next();//空格直接为换行	
				// String s = scanner.nextLine();//全部打印再换行	
				// System.out.println(s);	
			// }
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入您的姓名:");
			String name = scanner.nextLine();
			System.out.println("请输入您的年龄:");
			int age = scanner.nextInt();
			scanner.nextLine();	// 读走遗留的 \n
			System.out.println("请输入您的性别:");
			String sex = scanner.nextLine();
			System.out.println("请输入您的职业");
			String job=scanner.nextLine();
			System.out.println("登记成功!!!");
			System.out.println("姓名: " + name);
			System.out.println("年龄: " + age);
			System.out.println("性别: " + sex);
			System.out.println("职业: " + job);
	}
}