import java.util.Arrays;

public class Test {
    //练习插入排序 希尔排序 选择排序

    public static void insertSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            int end=i;
            int value=array[i+1];
            while(end>=0&&value<array[end]){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=value;
        }
    }

    public static void shellSort(int[] array) {
        int gap=array.length;
        while(gap>1){
            gap=gap/2;
            for(int i=0;i<array.length-gap;i++){
                int end=i;
                int value=array[end+gap];
                while(end>=0&&value<array[end]){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=value;
            }
        }
    }
    public static void selectSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            int start=i;
            int min=i;
            //每次找到剩下的所有数中最小的数的坐标
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            //交换
            int tmp=array[start];
            array[start]=array[min];
            array[min]=tmp;

        }
    }
    //双指针
    public static void selectSort1(int[] array) {
        int begin=0;
        int end=array.length-1;
        while(begin<end){
            int min=begin;
            int max=end;
            for(int i=begin;i<=end;i++){
                if(array[i]<array[min]){
                    min=i;
                }

                if (array[i]>array[max]){
                    max=i;
                }
            }
            swap(array,begin,min);
            //最大的数恰好在开始位置 交换和最大数的下标变为之前的min
            if(max==begin){
                max=min;
            }
            swap(array,end,max);
            begin++;
            end--;
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
        int[]copy3=arr.clone();
        int[]copy4=arr.clone();
        Arrays.sort(arr);
        System.out.println("Arrays.sort()排序"+Arrays.toString(arr));
        insertSort(copy1);
        System.out.println("插入排序"+Arrays.toString(copy1));
        shellSort(copy2);
        System.out.println("希尔排序"+Arrays.toString(copy2));
        selectSort(copy3);
        System.out.println("选择排序"+Arrays.toString(copy3));
        selectSort1(copy4);
        System.out.println("双指针选择排序"+Arrays.toString(copy4));
    }
}
