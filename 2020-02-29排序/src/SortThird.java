import java.util.Arrays;
import java.util.Stack;

public class SortThird {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //快排 递归
     /*
        快排递归：
        时间复杂度：O(nlogn)    最坏时间复杂度： 没有优化之前 O(n^2)
        稳定性：不稳定  基准值的位置进行交换的时候有可能改变相同元素的相对位置
        空间复杂度：logn
     */
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            // int mid = partition(arr, left, right);
            int mid = partition1(arr, left, right);
            //进行分组
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
    //非递归
    public static void quickSort1(int[] arr){
        int left=0;
        int right=arr.length-1;
        Stack<Integer>st=new Stack<>();
        st.push(right);
        st.push(left);
        while(!st.isEmpty()){
            left=st.pop();
            right=st.pop();
            int mid=partition(arr,left,right);
            if(mid+1<right){
                st.push(right);
                st.push(mid+1);
            }
            if(mid-1>left){
                st.push(mid-1);
                st.push(left);
            }
        }
    }
    //挖坑法
    public static int partition(int[] array, int left, int right) {
        int key=array[left];
        while(left<right){
            while(left<right&&array[right]>=key){
                right--;
            }
            array[left]=array[right];
            while(left<right&&array[left]<=key){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=key;
        return  left;
    }
    //前后遍历
    public static int partition1(int[] array, int left, int right) {
        int key=array[left];
        int prev=left;
        int cur=left+1;
        while(cur<=right){
            if(array[cur]<key&&++prev!=cur){
                swap(array,prev,cur);
            }
            cur++;
        }
        swap(array,left,prev);
        return prev;
    }
    public static void main(String[] args) {
        int[]arr={3,5,16,17,4,20};
        int[]arr1=arr.clone();
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        quickSort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
