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

    /**
     * @param size
     * @return
     */
    public static Integer [] generateRandomIntArray(int size){
        if(size<0)
            throw new RuntimeException("The size of array must be positive,but your size is "+size);
        Integer result [] = new Integer[size];
        for(int i = 0;i<size;i++){
            result[i] = random.nextInt(size);
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

}
