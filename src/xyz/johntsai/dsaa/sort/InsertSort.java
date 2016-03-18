package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class InsertSort {

    /**
     * 插入排序
     * <p>
     * before:3,5,1,4,2
     * <p>
     * 1>. 3,5,1,4,2
     * 2>. 3,5,1,4,2
     * 3>. 3,1,5,4,2-->1,3,5,4,2
     * 4>. 1,3,4,5,2
     * 5>. 1,3,4,2,5-->1,3,2,4,5-->1,2,3,4,5
     * <p>
     * after:1,2,3,4,5
     *
     * @param array
     */
    public static void insertSort(Integer[] array) {
        int sorted = 0;
        for(int i = sorted+1;i<array.length;i++){
            for(int j = 0;j<=sorted;j++){
                if(array[i]<array[j]){
                    Integer temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            sorted++;
        }

    }

    public static void main(String[] args) {
        Integer [] array = {3,5,1,4,2};
        insertSort(array);
        Utlis.printArray(array);
    }
}
