import java.util.Arrays;

public class TopK {
    //堆
    public  static  int[] myTopK(int[]array,int k){
       int []ret=Arrays.copyOf(array,k);
       MyHeap.createHeapSmall(ret,ret.length);
       for(int i=k;i<array.length;i++){
           if(array[i]>ret[0]){
               ret[0]=array[i];
               MyHeap.shiftDownSmall(ret,ret.length,0);
           }
       }
       return ret;
    }

    public static void main(String[] args) {
        int[]array={3,6,2,17,11,34,15,9,24,20,14};
        int[]top=myTopK(array,5);
        System.out.println(Arrays.toString(top));
    }
}
