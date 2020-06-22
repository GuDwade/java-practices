public class Reivew {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //插入
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

    //希尔
    public static void shellSort(int[] array) {
        int gap=array.length;
        while(gap>1){
            //最后一次gap==1 结束
            gap=gap/3+1;
            for(int i=0;i<array.length-gap;i++){
                //i: 表示已排序数据的最后一个位置
                int end=i;
                int val=array[end+gap];
                while(end>=0&&array[end]>val){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=val;
            }
        }
    }

    //选择
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

}
