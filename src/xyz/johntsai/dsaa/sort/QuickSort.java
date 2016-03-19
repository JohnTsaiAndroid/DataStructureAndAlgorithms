package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class QuickSort {

    /**
     * 快速排序
     * @param array
     *
     * 分治法的思想
     *
     * http://www.algolist.net/Algorithms/Sorting/Quicksort
     * https://en.wikipedia.org/wiki/Quicksort
     *
     * before:5,1,7,4,8,5,6,2,9,3
     * after:1,2,3,4,5,5,6,7,8,9
     *
     * 步骤:
     * 1.从数组中选取一个元素(任意值)作为中轴(pivot)
     * 2.分割:对数组进行重新排序,对于小于中轴的元素放置在中轴坐标,大于的放置在右边.中轴就在最终的位置
     * 3.递归:对第二步中分割出来的比中轴大的子数组和比中轴小的子数组重复进行第一,二步的操作
     *
     *
     * 中轴:5
     * 5,1,7,4,8,5,6,2,9,3
     * 5,1,3,4,8,5,6,2,9,7  (7-3)
     * 5,1,3,4,2,5,6,8,9,7  (8-2)
     * 小于中轴的:1,3,4,2
     * 大于等于的: 5,6,8,9,7
     *
     * 中轴元素和小于中轴的数组的最后一个元素交换位置:
     * 2,1,3,4,5,5,6,8,9,7
     * 对(2,1,3,4)和(5,6,8,9,7)进行第一二步相同操作
     * 依此类推...
     */
    public static void quickSort(Integer[] array){
         quicksort(array,0,array.length-1);
    }

    /**
     * 分割
     */
    private static int partition(Integer[]array,int low,int high){
        int pivot = array[high];
        int i = low;
        for(int j = low;j<high;j++){
            if(array[j]<=pivot){
                //交换a[i]和a[j]的值
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high]=temp;
        return i;
    }

    /**
     * 快速排序
     * @param array
     * @param low
     * @param high
     */
    private static void quicksort(Integer [] array,int low,int high){
        if(low<high){
            int pivot = partition(array,low,high);
            quicksort(array,low,pivot-1);
            quicksort(array,pivot+1,high);
        }
    }

    public static void main(String[] args) {
      Integer [] array = {5,1,7,4,8,5,6,2,9,3,100};
      quickSort(array);
      Utlis.printArray(array);
    }
}
