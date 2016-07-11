package xyz.johntsai.dsaa.sort;

import java.util.Arrays;

/**
 * Created by JohnTsai on 16/7/11.
 * 测试各个排序算法性能的测试类
 */
public class SortTest {


    public static void main(String[] args) {
        //生成待排序的数字数组
        Integer [] integers = Utlis.generateRandomIntArray(100000);
        Integer [] integers1 = Arrays.copyOf(integers,integers.length);
        Integer [] integers2 = Arrays.copyOf(integers,integers.length);
        Integer [] integers3 = Arrays.copyOf(integers,integers.length);
        Integer [] integers4 = Arrays.copyOf(integers,integers.length);
        Integer [] integers5 = Arrays.copyOf(integers,integers.length);
        Integer [] integers6 = Arrays.copyOf(integers,integers.length);
        Integer [] integers7 = Arrays.copyOf(integers,integers.length);
        Integer [] integers8 = Arrays.copyOf(integers,integers.length);
        Integer [] integers9 = Arrays.copyOf(integers,integers.length);

        System.out.println("待排序数组:"+Utlis.isSortedArray(integers));
        Utlis.printArray(integers);
        long startTime,endTime;

        //冒泡排序
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        startTime = System.currentTimeMillis();
        bubbleSort.bubbleSort(integers);
        endTime = System.currentTimeMillis();
        System.out.println("冒泡排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers));

        //快速排序
        QuickSort<Integer> integerQuickSort = new QuickSort<>();
        startTime = System.currentTimeMillis();
        integerQuickSort.quickSort(integers1);
        endTime = System.currentTimeMillis();
        System.out.println("快速排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers1));


        //计数排序
        startTime = System.currentTimeMillis();
        CountSort.countSort(integers2);
        endTime = System.currentTimeMillis();
        System.out.println("计数排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers2));

        //堆排序
        HeapSort<Integer> integerHeapSort = new HeapSort<>();
        startTime = System.currentTimeMillis();
        integerHeapSort.heapSort(integers3);
        endTime = System.currentTimeMillis();
        System.out.println("堆排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers3));


        //归并排序
        MergeSort<Integer> integerMergeSort = new MergeSort<>();
        startTime = System.currentTimeMillis();
        integerMergeSort.sort(integers4);
        endTime = System.currentTimeMillis();
        System.out.println("归并排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers4));

        //随机快速排序
        RQuickSort<Integer> integerRQuickSort = new RQuickSort<>();
        startTime=System.currentTimeMillis();
        integerRQuickSort.rquickSort(integers5);
        endTime = System.currentTimeMillis();
        System.out.println("随机快速排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers5));

        //选择排序
        SelectSort<Integer> integerSelectSort = new SelectSort<>();
        startTime = System.currentTimeMillis();
        integerSelectSort.selectSort(integers6);
        endTime = System.currentTimeMillis();
        System.out.println("选择排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers6));

        //希尔排序
        ShellSort<Integer> shellSort = new ShellSort<>();
        startTime = System.currentTimeMillis();
        shellSort.shellSort(integers7);
        endTime = System.currentTimeMillis();
        System.out.println("希尔排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers7));


        //插入排序
        InsertSort<Integer> integerInsertSort= new InsertSort<>();
        startTime = System.currentTimeMillis();
        integerInsertSort.insertSort(integers8);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers8));

        //基数排序
        startTime = System.currentTimeMillis();
        RadixSort.radixSort(integers9);
        endTime = System.currentTimeMillis();
        System.out.println("基数排序:(数字)"+(endTime-startTime)+"ms\n"
                +Utlis.isSortedArray(integers9));


    }
}
