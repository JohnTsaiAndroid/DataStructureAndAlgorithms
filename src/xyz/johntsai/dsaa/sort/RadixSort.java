package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/19.
 */
public class RadixSort {

    /**
     * 基数排序
     * <p>
     * 学习链接:
     * https://zh.wikipedia.org/wiki/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F
     *
     * @param array
     */
    public static void radixSort(Integer[] array) {
        //求最大的数
        int max = array[0];

        for (Integer integer : array) {
            if (integer > max) {
                max = integer;
            }
        }

        //求最大的数的位数
        int digit = 0;
        while (max != 0) {
            max = max / 10;
            digit++;
        }

        //数组的长度
        int length = array.length;

        //存各个位数的数组
        int[] bucket = new int[10];

        //循环digit次排序

        int m = 1;

        Integer[] temp = new Integer[length];

        for (int i = 0; i < digit; i++) {
            //初始化bucket数组
            for (int j = 0; j < bucket.length; j++) {
                bucket[j] = 0;
            }

            for (int k = 0; k < length; k++) {
                int result = (array[k] / m) % 10;
                bucket[result]++;
            }

            for (int n = 1; n < 10; n++) {
                bucket[n] += bucket[n - 1];
            }

            for (int n = length - 1; n >= 0; n--) {
                int result = (array[n] / m) % 10;
                temp[bucket[result] - 1] = array[n];
                bucket[result]--;
            }
            for (int n = 0; n < length; n++) {
                array[n] = temp[n];
            }
            m = m * 10;
        }

    }

    /**
     *
     *
     * 1. 1,432,32, 5, 675, 33, 22, 3, 567
     *   0:           ---0
     *   1:1          ---1
     *   2:432,32,22  ---4
     *   3:33,3       ---6
     *   4:           ---6
     *   5:5,675      ---8
     *   6:           ---8
     *   7:567        ---9
     *   8:           ---9
     *   9:           ---9
     *
     *   after:
     *
     *
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        Integer[] array = {1, 432, 32, 5, 675, 33, 22, 3, 567};
        radixSort(array);
        Utlis.printArray(array);
    }

}
