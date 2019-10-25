public class VariableDemo{
	public static void main(String[] args){
		int a;
		a=10;
		System.out.println(a);
		int intmin=Integer.MIN_VALUE;
		int intmax=Integer.MAX_VALUE;
		System.out.println(intmin);
		System.out.println(intmax);
		byte bytemin=Byte.MIN_VALUE;
		byte bytemax=Byte.MAX_VALUE;
		System.out.println("bytemin="+bytemin);
		System.out.println("bytemax="+bytemax);
		long minLong=Long.MIN_VALUE;
		long maxLong=Long.MAX_VALUE;
		System.out.println(minLong);
		System.out.println(maxLong);
		System.out.println("===================");
		short minShort=Short.MIN_VALUE;
		short maxShort=Short.MAX_VALUE;
		System.out.println(minShort);
		System.out.println(maxShort);
		short maxShortpul1=(short)(maxShort+1);
		System.out.println(maxShortpul1);/*整形存在min,max溢出之后循环*/
		short minShortsub1=(short)(minShort-1);
		System.out.println(minShortsub1);
		System.out.println("===================");
		int aINT=010;
		System.out.println(aINT);
		int b=0x3c;
		System.out.println(a);
		long aLong=100L;
		System.out.println(aLong);
		byte d=10;
		/*byte and short 范围内成立*/
		System.out.println(d);
		/*byte c=128;范围外*/
		int dInt=1;
		int eInt=2;
		System.out.println(dInt/eInt);
		System.out.println(dInt*1.0/eInt);//类型提升
		double e=1.0;
		System.out.println(e);
		System.out.println("===================");
		char X='中';
		char Y='☆';
		System.out.println(X);
		System.out.println(Y);
		System.out.println('☆');
	}
	}
