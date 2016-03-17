package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/17.
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * http://www.sorting-algorithms.com/bubble-sort
     * @param array
     */
    public void bubbleSort(int[] array){
        boolean swapped = true;
        int i = 0;
        int temp;
        while (swapped){
            swapped = false;
            i++;
            for(int j = 0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int array [] = {5,4,1,3,2};
        bubbleSort.bubbleSort(array);
        for(int i:array){
            System.out.println(i);
        }
    }
}