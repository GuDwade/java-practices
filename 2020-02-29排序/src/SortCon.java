import java.util.Arrays;

public class SortCon {
    public static void shiftDownMax(int[] array, int size, int index) {
        int left=index*2+1;
        while(left<size){
            int max=left;
            int right=index*2+2;
            if(right<size&&array[right]>array[left]){
                max=right;
            }
            if(array[index]>=array[max]){
                break;
            }
            swap(array,index,max);
            index=max;
            left=index*2+1;
        }
    }
    public static void createHeap(int[] array) {
        for(int i=(array.length-2)/2;i>=0;i--){
            shiftDownMax(array,array.length,i);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /*堆排序
        时间复杂度  ：n*log(n)
        稳点性：不稳定
        空间复杂度：o(1)
    */
    public static void heapSort(int[] array) {
        //建堆
        createHeap(array);
        for(int i=0;i<array.length;i++){
            //堆头（最大元素）与堆尾交换
            swap(array,0,array.length-1-i);
            //向下调整 长度-1
            shiftDownMax(array,array.length-1-i,0);
        }
    }
    /*冒泡排序
        时间复杂度  ：o(n)-o(n^2)
        稳点性：稳定
        空间复杂度：o(1)
    */
    public static void bubbleSort(int[] array) {
        /*
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
       */
        int len=array.length;
        while(len>0){
            boolean flag=true;
            for(int i=0;i<len-1;i++){
                if(array[i]>array[i+1]){
                    swap(array,i,i+1);
                    flag=false;
                }
            }
            //这轮没有发生交换
            if(flag){
                break;
            }
            len--;
        }
    }

    public static int partition(int[] array, int left, int right) {
        int val=array[left];
        int start=left;
        while(left<right){
            //找到第一个比基准值小的数
            while(left<right&&array[right]>=val){
                right--;
            }
            //找到第一个比基准值大的数
            while(left<right&&array[left]<=val){
               left++;
            }
            //交换
            swap(array,left,right);
        }
        //把基准值和相遇的位置的数据进行交换
        swap(array,start,left);
        return left;
    }
    //快排
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int mid = partition(arr, left, right);
            //进行分组
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
    public static void main(String[] args) {
        int[]arr={3,5,16,17,4,20};
        int[]arr1=arr.clone();
        int[]arr2=arr.clone();
        createHeap(arr);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
        quickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr2));
    }
}
