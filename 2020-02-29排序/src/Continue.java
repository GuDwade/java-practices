import java.util.Arrays;

public class Continue {
    //复习归并排序
    //归并排序
    public static void mergeSort(int[] array) {
        int[]helper=new int[array.length];
        mergeSortInternal(array, 0, array.length-1,helper);
    }
    //递归 分组
    private static void mergeSortInternal(int[] array, int left, int right,int[]helper) {
        if(left>=right){
            return;
        }
        //分治
        int mid=(left+right)/2;
        //分别对[left,mid]和[mid+1,right]小数组排序
        mergeSortInternal(array,left,mid,helper);
        mergeSortInternal(array,mid+1,right,helper);
        //归并  小数组都有序了
        merge(array,left,mid,right,helper);

    }
    //合并数组
    private static void merge(int[] array, int left, int mid, int right,int[]helper) {
        int begin1=left, end1=mid;
        int begin2=mid+1, end2=right;
        int index=left;

        while(begin1<=end1&&begin2<=end2){
            if(array[begin1]<array[begin2]){
                helper[index++]=array[begin1++];
            }else{
                helper[index++]=array[begin2++];
            }
        }

        while(begin1<=end1)
            helper[index++]=array[begin1++];
        while(begin2<=end2)
            helper[index++]=array[begin2++];
        //拷贝
        for(int i=left;i<=right;i++){
            array[i]=helper[i];
        }
    }
    //非递归
    public static void mergeNul(int[]arr){
        int []helper=new int[arr.length];
        for(int i=1;i<arr.length;i=i*2){
            for(int j=0;j<arr.length;j+=2*i){
                int left=j;
                int mid=j+i-1;
                //右半部分没有数据，不用进行归并
                if(mid>=arr.length-1){
                    continue;
                }
                int right=j+2*i-1;
                if(right>arr.length-1){
                    right=arr.length-1;
                }
                merge(arr,left,mid,right,helper);
            }
        }
    }
    public static void main(String[] args) {
        int[]arr={16,5,14,3,7,8,23,45,34,12,26};
        int[]copy=arr.clone();
        mergeSort(arr);
        System.out.println("递归完成:");
        System.out.println(Arrays.toString(arr));
        mergeNul(copy);
        System.out.println("非递归完成:");
        System.out.println(Arrays.toString(copy));
    }
}
