 class TimeSetting{
	private int hour;
	private int min;
	private int sec;
	public TimeSetting(int hour,int min,int sec){
		if(hour>23||hour<0){
			System.out.println("不支持的小时格式");
			return;
		}
		if(min>59||min<0){
			System.out.println("不支持的分钟格式");
			return;
		}
		if(sec>59||sec<0){
			System.out.println("不支持的秒钟格式");
			return;
		}
		this.hour=hour;
		this.min=min;
		this.sec=sec;
	}
	@Override
	public String toString(){
		return String.format("%02d:%02d:%02d",hour,min,sec);
	}
	public void add(int secs){
		sec+=secs;
		while(sec>59){
			sec-=60;
			min+=1;
			if(min>59){
				min-=60;
				hour+=1;
			}
			if(hour>23){
				hour=0;
			}
		}	
	}
	public void sub(int secs){
		sec-=secs;
		while(sec<0){
			sec+=60;
			min-=1;
			if(min<0){
				min+=60;
				hour-=1;
			}
			if(hour<0){
				hour=23;
			}
		}
	}
}
public class MyTime{
	public static void main(String[]args){
		TimeSetting s=new TimeSetting(15,34,45);
		System.out.println(s);
		s.add(45); 
		System.out.println(s);
		s.sub(66); 
		System.out.println(s);
	}
}