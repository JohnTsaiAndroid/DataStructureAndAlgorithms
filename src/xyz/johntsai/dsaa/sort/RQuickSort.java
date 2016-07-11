package xyz.johntsai.dsaa.sort;

import java.util.Random;

/**
 * Created by JohnTsai on 16/3/19.
 */
public class RQuickSort<T extends Comparable<T>> {
    /**
     *
     * 随机快速排序法
     * https://alg12.wikischolars.columbia.edu/file/view/QUICKSORT.pdf
     * http://tuvalu.santafe.edu/~aaronc/courses/5454/csci5454_spring2013_L2.pdf
     *
     * 采用随机法选取中轴减少最差情况的出现来提高算法的效率
     *
     *
     */
    public  void rquickSort(T[]array){
         rquicksort(array,0,array.length-1);
    }

    /**
     * 随机选取中轴,并分割
     * @return
     */
    private  int randomPartition(T[]array,int low,int high){
        //产生随机数
        Random random = new Random();
        int randompivot = random.nextInt(high-low)+low;
        //最右的数和随机产生的中轴的交换值

        T tem = array[randompivot];
        array[randompivot] = array[high];
        array[high] =tem;

        T pivot = array[high];
        int i = low;
        for(int j = low;j<high;j++){
            if(array[j].compareTo(pivot)<=0){
                //交换a[i]和a[j]的值
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        T temp = array[i];
        array[i] = array[high];
        array[high]=temp;
        return i;
    }

    private  void rquicksort(T[]array,int low,int high){
        if(low<high){
            int pivot = randomPartition(array,low,high);
            rquicksort(array,low,pivot-1);
            rquicksort(array,pivot+1,high);
        }
    }

    public static void main(String[] args) {
        Integer [] array = {5,1,7,4,8,5,6,2,9,3};
        RQuickSort<Integer> sort = new RQuickSort<>();
        sort.rquickSort(array);
        Utlis.printArray(array);
    }

}
