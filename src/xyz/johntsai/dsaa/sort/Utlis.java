package xyz.johntsai.dsaa.sort;

import java.util.Random;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class Utlis{

    private Utlis(){

    }

    private static Random random = new Random();

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;

    private static final int INT_ARRAT_RANGE = 100_000_000;

    public static Integer [] generateRandomIntArray(int size){
        return generateRandomIntArray(size,INT_ARRAT_RANGE);
    }

    /**
     * 生成随机数组
     * @param size
     * @return
     */
    public static Integer [] generateRandomIntArray(int size,int range){
        if(size<0)
            throw new RuntimeException("The size of array must be positive,but your size is "+size);
        Integer result [] = new Integer[size];
        for(int i = 0;i<size;i++){
            result[i] = random.nextInt(range);
        }
        return result;
    }

    /**
     * 生成升序数组
     * @param size
     * @return
     */
    public static Integer [] generateAscOrderIntArray(int size){
        if(size<0)
            throw new RuntimeException("The size of array must be positive,but your size is "+size);
        Integer result[] = new Integer[size];
        for(int i = 0;i<size;i++){
            result[i] = i;
        }
        return result;
    }

    public static Integer [] generateDesOrderIntArray(int size){
        if(size<0)
            throw new RuntimeException("The size of array must be positive,but your size is "+size);
        Integer result[] = new Integer[size];
        for(int i=0;i<size;i++){
            result[i] = size - i;
        }
        return result;
    }

    /**
     * A--Z的ASCII码范围是:65--90
     *
     * @param size
     * @return
     */
    public static Character [] generateRandomCharacterArray(int size){
        if(size<0)
            throw new RuntimeException("The size of array must be positive,but your size is "+size);
        Character [] result = new Character[size];
        for(int i = 0;i<size;i++){
            result[i] = (char)('A'+random.nextInt(26));
        }
        return result;
    }

    /**
     * 打印数组
     * @param array
     * @param <E>
     */
    public static <E> void printArray( E[] array){
          for(E e:array){
              System.out.print(e.toString()+" ");
          }
        System.out.println();
    }

    public static <T extends Comparable<T>>boolean isSortedArray(T [] array){
        if(array==null||array.length==0)
            throw new RuntimeException("array must not be empty");
        for(int i = 0;i<array.length-1;i++){
            if(array[i].compareTo(array[i+1])>0)
                return false;
        }
        return true;
    }
}
