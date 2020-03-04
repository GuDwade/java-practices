import java.util.Arrays;

public class Perimeter {
    public static int largestPerimeter(int[] A) {
        bubbleSort(A);
        for(int i=A.length-1;i>=2;i--){
            int a=A[i];
            int b=A[i-1];
            int c=A[i-2];
            if(a<b+c){
                return a+b+c;
            }
        }
        return 0;
    }
    public static void bubbleSort(int[] array) {
        //总共执行array.length-1轮排序
        for(int i=0;i<array.length-1;i++){
            //每轮选出一个最大数  比较次数相对少一次
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]triangle={3,5,8,1};
        System.out.println(largestPerimeter(triangle));
    }
}
