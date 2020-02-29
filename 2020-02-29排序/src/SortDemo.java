import java.util.Arrays;

public class SortDemo {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /*插入排序
        时间复杂度  ：最坏 :o(n^2) 逆序序列  最好 :o(n) 顺序序列
        稳点性：稳定
        空间复杂度：开辟常数个空间   o(1)
    */
    public static void insertSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            //val下一个要排序元素位置
            int val=array[i+1];
            //i表示已经排好序的最后一个元素
            int end=i;
            while(end>=0&&array[end]>val){
                //将大的数向后挪
                array[end+1]=array[end];
                //向前搜索
                end--;
            }
            // end =-1 到头
            array[end+1]=val;
        }
    }

    public static void insertSort1(int[] array) {
        for(int i=1;i<array.length;i++){
            //i表示下一个要排序元素位置
            //end表示已经排好序的最后一个元素
            int end=i-1;
            int val=array[i];
            while(end>=0&&array[end]>val){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=val;
        }
    }
    /*希尔排序
        时间复杂度  ：最坏 :o(n^2)   最好 :o(n)
        稳点性：不稳定
        空间复杂度：开辟常数个空间   o(1)
    */
    public static void shellSort(int[] array) {
        int gap=array.length;
        while(gap>1){
            //最后一次gap==1 结束
            gap=gap/3+1;
            for(int i=0;i<array.length-gap;i++){
                //i: 表示已排序数据的最后一个位置
                int end=i;
                int val=array[end+gap];
                while(i>=0&&array[end]>val){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=val;
            }
        }
    }
    /*选择排序：
           时间复杂度： O(n^2)
           稳定性：可以让它稳定/不稳定
           空间复杂度：  常数空间  ---> O(1)
    */
    public static void selectSort(int[] array) {
        for(int i=array.length-1;i>0;i--){
            //i: 未排序的最大位置
            int end=i;
            int max=i;
            for(int j=end-1;j>=0;j--){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            int t=array[end];
            array[end]=array[max];
            array[max]=t;
        }
    }
    //双指针
    public static void selectSort1(int[] arr){
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end){

            int minIdx = begin;
            int maxIdx = begin;
            for(int i = begin; i <= end; ++i){
                //最小值选前面
                if(arr[i] < arr[minIdx])
                    minIdx = i;
                //最大值选后面
                if(arr[i] >= arr[maxIdx])
                    maxIdx = i;
            }
            swap(arr, begin, minIdx);
            //如果最大值在起始位置，则经过上面的交换之后，最大值被移动到minIdx指向的位置
            if(maxIdx == begin) {
                maxIdx = minIdx;
            }
            swap(arr, end, maxIdx);
            ++begin;
            --end;
        }
    }
    public static void main(String[] args) {
        int[]arr={12,4,7,12,34,23,17,45};
        int[]arr1=arr.clone();
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        insertSort1(arr1);
        System.out.println(Arrays.toString(arr1));
        int[]arr2=arr.clone();
        shellSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[]arr3=arr.clone();
        selectSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
