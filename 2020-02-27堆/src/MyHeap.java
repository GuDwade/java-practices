import java.util.Arrays;

public class MyHeap {
    //左右已经为堆
    //小根堆  自顶向下
    public static void shiftDownSmall(int[] array, int size, int index) {
        int left=index*2+1;
        while(left<size){
            int min=left;
            int right=index*2+2;
            if(right<size&&array[right]<array[left]){
                min=right;
            }
            if(array[index]<array[min]){
                break;
            }
            //将更小的值 调上
            int tmp=array[index];
            array[index]=array[min];
            array[min]=tmp;
            //更新 index left
            index=min;
            left=index*2+1;
        }
    }
    //左右不为堆
    //先从最小的树开始  保证子结构也为堆
    public static void createHeapSmall(int[] array, int size) {
        for (int i = (size -2) / 2; i >= 0; i--) {
            shiftDownSmall(array, size, i);
        }
    }
    //大堆
    public static void shiftDownBig(int[] array, int size, int index) {
        int left=index*2+1;
        while(left<size){
            int max=left;
            int right=index*2+2;
            if(right<size&&array[right]>array[left]){
                max=right;
            }
            if(array[index]>array[max]){
                break;
            }
            //将更大的值 调上
            int tmp=array[index];
            array[index]=array[max];
            array[max]=tmp;
            //更新 index left
            index=max;
            left=index*2+1;
        }
    }
    //建大堆
    public static void createHeapBig(int[] array, int size) {
        for (int i = (size -2) / 2; i >= 0; i--) {
            shiftDownBig(array, size, i);
        }
    }
    //向上调整 大堆
    public static void shiftUpBig(int[] array,int index){
        while(index>0){
            int parent=(index-1)/2;
            if(array[parent]>array[index]){
                break;
            }
            int tmp=array[parent];
            array[parent]=array[index];
            array[index]=tmp;
            index=parent;
        }
    }
    //向上调整 小堆
    public static void shiftUpSmall(int[] array, int index){
        while(index>0){
            int parent=(index-1)/2;
            if(array[parent]<array[index]){
                break;
            }
            int tmp=array[parent];
            array[parent]=array[index];
            array[index]=tmp;
            index=parent;
        }
    }

    public static void main(String[] args) {
        int[] array={27,15,19,18,28,34,65,49,25,37};
        shiftDownSmall(array,array.length,0);
        System.out.println(Arrays.toString(array));
        int[] array1= { 12,11,9,10,8,6,5 };
        createHeapSmall(array1,array1.length);
        System.out.println(Arrays.toString(array1));
        int[]array2={ 1,5,3,8,7,6 };
        createHeapBig(array2,array2.length);
        System.out.println(Arrays.toString(array2));
    }
}
