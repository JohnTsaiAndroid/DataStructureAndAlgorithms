package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class MergeSort {
    /**
     * 归并排序
     *
     * 分而治之的算法思想(divide and conquer)
     *
     * 相关学习链接:
     * https://en.wikipedia.org/wiki/Merge_sort
     * http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/mergeSort.htm
     * http://www.sorting-algorithms.com/merge-sort
     *
     * 步骤:
     * 1.分:若数组中有0或1个元素直接返回,否则将数组a[p...r]等分为两个子数组a[p...q]和a[q+1...p]
     * 2.治:对子数组a[p...q],a[q+1...r]和采取递归的方式排序
     * 3.合:合并已经排好序的两个子数组到数组中
     *
     *
     *
     * before:5,1,7,4,8,5,6,2,9,3
     *
     * sorting:
     * 1>. split:5,1,7,4,8   5,6,2,9,3 -->merge
     * 2>. split:5,1,7 4,8......
     * 3>. split:5,1  7....
     * 4>. split:5  1 -->merge:1,5  7--->merge:1,5,7
     * 5>. 1,4,5,7,8  2,3,5,6,9---->merge:1,2,3,4,5,5,6,7,8,9
     *
     */


    public static void mergeSort(Integer [] array,Integer [] temp,int left,int right){
        //递归结束的条件
        if(left>=right)
            return;
        //分割
        int middle = (right+left)/2;
        //递归
        int left1 = left,right1 = middle;
        int left2 = middle+1,right2 = right;

        mergeSort(array,temp,left,middle);
        mergeSort(array,temp,middle+1,right);

        //合并
        int i = left;
        while (left1<=right1&&left2<=right2){
             temp[i++] = array[left1]<array[left2]?array[left1++]:array[left2++];
        }

        //对于左边的数 可能还没放完
        while(left1<=right1){
            temp[i++]=array[left1++];
        }
        //对于右边的数 也可能没放完
        while (left2<=right2){
            temp[i++]=array[left2++];
        }

        //将排序好的数组赋值到原数组上
        for(i=left;i<=right;i++){
            array[i]= temp[i];
        }
    }

    public static void sort(Integer[] array){
        Integer[] temp = new Integer[array.length];
        mergeSort(array,temp,0,array.length-1);
    }

    public static void main(String[] args) {
        Integer[] array = {5,1,7,4,8,5,6,2,9,3};
        sort(array);
        Utlis.printArray(array);
    }
}
