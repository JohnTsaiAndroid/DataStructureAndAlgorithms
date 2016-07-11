package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class InsertSort <T extends Comparable<T>>{

    /**
     * 插入排序
     *
     * 时间复杂度:O(n^2)
     *
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
    public  void insertSort(T[] array) {
        int sorted = 0;
        for(int i = sorted+1;i<array.length;i++){
            for(int j = 0;j<=sorted;j++){
                if(array[i].compareTo(array[j])<0){
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            sorted++;
        }

    }

    public static void main(String[] args) {
        Integer [] array = {3,5,1,4,2};
        InsertSort<Integer> sort = new InsertSort<>();
        sort.insertSort(array);
        Utlis.printArray(array);
    }
}
