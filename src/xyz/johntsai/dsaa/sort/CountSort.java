package xyz.johntsai.dsaa.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class CountSort {

    /**
     * 计数排序
     */
    public static void countSort(Integer [] array){
     //获得数组最大值
        int max = array[0];
        int min = array[0];
        for(Integer integer :array){
            if(integer>max)
                max = integer;
            if(integer<min)
                min = integer;
        }
        int[]countArray = new int[max-min+1];
        for(Integer integer:array){
            int value = integer-min;
            countArray[value]++;
        }
        int i = 0;
        for(int k = 0;k<countArray.length;k++){
            for(int j = 0;j<countArray[k];j++){
                array[i++]=min+k;
            }
        }
    }

    public static void main(String[] args) {
        Integer[]array = {5,1,7,4,8,5,6,2,9,3,100};
        countSort(array);
        Utlis.printArray(array);
    }

}
