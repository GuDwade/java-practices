import java.util.Arrays;

public class SortForth {
    //归并排序
    /*
        归并递归：
        时间复杂度：O(nlogn)
        稳定性：稳定
        空间复杂度：O(n)  需要辅助空间对元素进行归并，不能原地归并
     */
    public static void merge(int[]arr){
        int[]tmp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
    }
    public static void mergeSort(int[] array,int left,int right,int[] tmp) {
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergeSort(array,left,mid,tmp);
        mergeSort(array,mid+1,right,tmp);
        mergeInternal(array,left,mid,right,tmp);
    }
    //归并数组
    private static void mergeInternal(int[] array, int left, int mid, int right,int[]tmp) {
        int begin1=left ,en1=mid;
        int begin2=mid+1,end2=right;
        int indix=left;
        while(begin1<=en1&&begin2<=end2){
            if(array[begin1]<=array[begin2]){
                tmp[indix++]=array[begin1++];
            }else{
                tmp[indix++]=array[begin2++];
            }
        }
        while (begin1<=en1)
            tmp[indix++]=array[begin1++];

        while (begin2<=end2)
            tmp[indix++]=array[begin2++];
        for(int j=left;j<=right;j++){
            array[j]=tmp[j];
        }
    }
    //非递归
    public static void mergeNul(int[]arr){
        int[]tmp=new int[arr.length];
        //i: 每次归并的元素个数
        for(int i=1;i<arr.length;i=2*i){
            // j: 下一次归并的起始位置
            for(int j=0;j<arr.length;j+=2*i){
                int left=j;
                int mid=j+i-1;
                //右半部分没有数据，不用进行归并
                if(mid>=arr.length-1){
                    continue;
                }
                int right=j+2*i-1;
                if(right>=arr.length){
                    right=arr.length-1;
                }
                mergeInternal(arr,left,mid,right,tmp);
            }
        }
    }

    public static void main(String[] args) {
        int[]arr={3,17,23,15,6,8,34,11,25};
        int[]arr1=arr.clone();
        System.out.println(Arrays.toString(arr));
        merge(arr);
        System.out.println(Arrays.toString(arr));
        mergeNul(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
