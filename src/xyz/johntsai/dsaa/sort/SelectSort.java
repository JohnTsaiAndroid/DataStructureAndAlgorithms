package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class SelectSort <T extends Comparable<T>>{

    /**
     * 选择排序
     *
     * 时间复杂度:O(n^2)
     *
     * @param array
     */
    public  void selectSort(T[] array){
        int min;
        boolean swapped = false;
        for(int i = 0;i< array.length-1;i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] .compareTo( array[min])<0) {
                    min = j;
                    swapped = true;
                }
            }
            if (swapped) {
                T temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5,3,1,2,4,6,3,2,7,5,4};
        SelectSort<Integer> sort = new SelectSort<>();
        sort.selectSort(array);
        Utlis.printArray(array);
    }

}
