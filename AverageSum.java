public  class AverageSum{
	public static void main(String[] args){
		if(args.length==0){
			System.out.println("至少输入一个数字");
		return;
		}
		int sum=0;
		int i=0;
		while(i<args.length)
		{
		sum=sum+Integer.parseInt(args[i]);
		i++;
		}
		double average=sum/args.length;
		System.out.println(average);
	}
	
}