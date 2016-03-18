package xyz.johntsai.dsaa.sort;

/**
 * Created by JohnTsai on 16/3/18.
 */
public class Utlis{

    private Utlis(){

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
    }

}
