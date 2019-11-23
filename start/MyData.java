public class MyData{
	private int year=1970;
	private int month=1;
	private int day=1;
	private final int[]Day_OF_Month={
		31,28,31,30,31,30,
		31,31,30,31,30,31};
	private boolean isLeapYear(int year){
		if(year%400==0||(year%4==0&&year%100!=0)){
			return true;
		}else{
			return false;
		}
	}
	private int getDayOfMonth(int year,int month){
		if(month!=2){
			return Day_OF_Month[month-1];
		}else if(isLeapYear(year)){
			return 29;
		}else{
			return 28;
		}	
	}
	public MyData(){
	}
	public MyData(int year,int month,int day){
		if(year<1970){
			System.out.println("不支持的年份");
			return;
		}
		if(month<1||month>12){
			System.out.println("不支持的月份");
			return;
		}
		if(day<1||day>getDayOfMonth(year,month)){
			System.out.println("不支持的天数");
			return;
		}
		this.year=year;
		this.month=month;
		this.day=day;
	}
	@Override
	public String toString(){
		return String.format ("%04d-%02d-%02d",year,month,day);
	}
	public void add(int days){
		day+=days;
		while(day>getDayOfMonth(year,month)){
			day-=getDayOfMonth(year,month);
			month+=1;
			if(month>12){
				month=1;
				year+=1;
			}
			
		}
	}
	public void sub(int days){
		day-=days;
		while(day<1){
			month-=1;
			day+=getDayOfMonth(year,month);//加的是当前月的天数
			if(month<1 ){
				month=12;
				year-=1;
			}
			
		}
	}
	public static void main(String[]args){
		MyData data=new MyData(2019,1,1);
		System.out.println(data);
		data.add(59);
		System.out.println(data);
		MyData data1=new MyData(2019,11,12);
		System.out.println(data1);
		data1.sub(11);
		System.out.println(data1);
	}
}