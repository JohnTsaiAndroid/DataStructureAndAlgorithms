package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/17.
 */
public class BubbleSort<T extends Comparable<T>> {

    /**
     * 冒泡排序
     * http://www.sorting-algorithms.com/bubble-sort
     *
     * 时间复杂度:O(n^2)
     *
     * @param array
     */
    public  void bubbleSort(T[] array){
        boolean swapped = true;
        int i = 0;
        T temp;
        while (swapped){
            swapped = false;
            i++;
            for(int j = 0;j<array.length-i;j++){
                if(array[j].compareTo(array[j+1])>0){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer array [] = {5,4,1,3,2};
        Character characters [] = {'c','z','b','e','f','a'};

        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.bubbleSort(array);
        Utlis.printArray(array);

        BubbleSort<Character> characterBubbleSort = new BubbleSort<>();
        characterBubbleSort.bubbleSort(characters);
        Utlis.printArray(characters);

    }
}
