package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/7/3.
 */
public class ShellSort {
    /**
     * 希尔排序
     * 基于插入排序
     *
     * https://zh.wikipedia.org/wiki/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F
     *
     * @param array
     */
    public static void shellSort(Integer [] array){
        int length = array.length;
        int h = 1;
        //获取步长
        while(h<length/3)
            h=3*h+1;
        while(h>=1){
            for(int i = h;i<length;i++){
                for(int j = i;j>=h&&array[j]<array[j-h];j-=h){
                    int temp = array[j];
                    array[j]=array[j-h];
                    array[j-h]=temp;
                }
            }
            h=h/3;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5,3,1,2,4,6,3,2,7,5,4};
        shellSort(array);
        Utlis.printArray(array);
    }
}
