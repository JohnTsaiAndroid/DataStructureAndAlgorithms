package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class SelectSort {

    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(Integer[] array){
        int min;
        boolean swapped = false;
        for(int i = 0;i< array.length-1;i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                    swapped = true;
                }
            }
            if (swapped) {
                Integer temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5,3,1,2,4,6,3,2,7,5,4};
        selectSort(array);
        Utlis.printArray(array);
    }

}
