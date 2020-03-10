import java.util.Arrays;

public class Review {
    //复习堆排序 冒泡排序
    //向下调整 建大堆
    public static void shiftDown(int[] array, int size, int index) {
        int left=2*index+1;
        while(left<size){
            int max=left;
            int right=2*index+2;
            if(right<size&&array[right]>array[left]){
                max=right;
            }
            if (array[index]>=array[max]){
                break;
            }
            if(array[index]<array[max]){
                swap(array,index,max);
            }
            index=max;
            left=2*index+1;
        }
    }
    //堆排序
    public static void heapSort(int[] array) {
        //建堆
        for(int i=array.length-2/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
        //将堆顶（最大元素）与最后一位交换
        int end=array.length-1;
        while(end>0){
            swap(array,0,end);
            shiftDown(array,end,0);
            end--;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        /*
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
        */
        //len表示未排序元素的个数
        int len=array.length;
        while(len>0){
            boolean flag=true;
            for(int i=0;i<len-1;i++){
                if (array[i]>array[i+1]){
                    swap(array,i,i+1);
                    flag=false;
                }
            }
            if(flag){
                break;
            }
            len--;
        }

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[]arr={16,5,14,3,7,8,23,45,34,12,26};
        int[]copy1=arr.clone();
        int[]copy2=arr.clone();
        Arrays.sort(arr);
        System.out.println("Arrays.sort()排序"+Arrays.toString(arr));
        heapSort(copy1);
        System.out.println("堆排序"+Arrays.toString(copy1));
        bubbleSort(copy2);
        System.out.println("冒泡排序"+Arrays.toString(copy2));
    }
}
