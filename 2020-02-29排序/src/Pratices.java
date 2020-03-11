import java.util.Arrays;
import java.util.Stack;

public class Pratices {
    //复习快速排序
    //递归
    public static void quickSort(int[] arr, int left, int right){
        if(left<right){
            //int mid=partition(arr,left,right);
            //int mid=partition1(arr,left,right);
            int mid=partition2(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    //Hoare法
    public static int partition(int[] array, int left, int right) {
       int value=array[left];
       int start=left;
       while(left<right){
           while(left<right&&array[right]>=value){
               right--;
           }
           while(left<right&&array[left]<=value){
               left++;
           }
           if(left<right){
                swap(array,left,right);
           }
       }
       swap(array,start,left);
       return left;
    }
    //挖坑法
    public static int partition1(int[] array, int left, int right) {
        int value=array[left];
        while(left<right){
            while(left<right&&array[right]>=value){
                right--;
            }
            array[left]=array[right];
            while(left<right&&array[left]<=value){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=value;
        return  left;
    }
    //前后遍历法
    public static int partition2(int[] array, int left, int right) {
        int value=array[left];
        int start=left;
        //prev表示最后一个小于value的值
        int prev=left;
        //cur表示下一个小于value的值
        int cur=left+1;
        while(cur<=right){
            //cur找到下一个小与value的位置 并且两位之间有大于value的值
            if(array[cur]<value&&++prev!=cur){
                swap(array,prev,cur);
            }
            cur++;
        }
        swap(array,prev,start);
        return prev;
    }
    //迭代
    public static void quickSort(int[] array) {
        Stack<Integer>stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left=stack.pop();
            int right=stack.pop();
            int mid=partition(array,left,right);
            if(right>mid+1){
                stack.push(right);
                stack.push(mid+1);
            }
            if(left<mid-1){
                stack.push(mid-1);
                stack.push(left);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[]arr={16,5,14,3,17,7,8,23,45,34,12,26};
        int[]arr1=arr.clone();
        //partition2(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("递归完成：");
        System.out.println(Arrays.toString(arr));
        quickSort(arr1);
        System.out.println("迭代完成：");
        System.out.println(Arrays.toString(arr1));
    }

}
