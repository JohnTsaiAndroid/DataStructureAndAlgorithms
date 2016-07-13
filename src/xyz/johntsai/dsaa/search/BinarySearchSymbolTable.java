package xyz.johntsai.dsaa.search;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JohnTsai on 16/7/11.
 * 二分查找(基于有序数组)
 */
public class BinarySearchSymbolTable<K extends Comparable<K>,V>{

    //分别存放键值对的数组
    private K [] keys;
    private V [] values;
    //数组大小
    private int N = 0;

    public BinarySearchSymbolTable(int capacity){
       keys = (K[]) new Comparable[capacity];
       values = (V[]) new Object[capacity];
    }

    /**
     * 获取符号表的大小
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 根据键获取值
     * @param key
     * @return
     */
    public V get(K key){
        if(isEmpty())
            return null;
        int index = rank(key);
        if(index<N&&keys[index].compareTo(key)==0)
            return values[index];
        else
            return null;
    }

    private int rank(K key) {
        int low = 0;
        int high = N-1;
        while(low<=high){
            int middle = (low+high)/2;
            int compare = key.compareTo(keys[middle]);
            if(compare>0){
                low = middle+1;
            }else if(compare<0){
                high = middle-1;
            }else{
                return middle;
            }
        }
        return low;
    }

    private int rank(K key,int low,int high){
        if(low>high)
            return low;
        int middle = (low+high)/2;
        int compare = key.compareTo(keys[middle]);
        if(compare>0){
            return rank(key,middle+1,high);
        }else if(compare<0){
            return rank(key,low,middle-1);
        }else{
            return middle;
        }
    }

    public boolean isEmpty() {
        return N==0;
    }

    public void delete(K key){
        if(key==null)
            throw new NullPointerException("the key can't be null");
        int index = rank(key);
        if(index>=N)
            return;
        for(int i = index;i<N-1;i++){
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        N--;
        keys[N] = null;
        values[N] = null;
        if(N>0&&N==keys.length/4)
            resize(keys.length/2);
    }

    public void put(K key,V value){
        if(key == null)
           throw new NullPointerException("the key can't be null");
        if(value==null){
            delete(key);
            return;
        }
        int index = rank(key);
        if(index<N&&keys[index].compareTo(key)==0){
            values[index] = value;
            return;
        }
        if(N==keys.length)
            resize(2*N);
        for(int j = N;j>index;j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[index] = key;
        values[index] = value;
        N++;
    }

    private void resize(int i) {
        K [] ktemp = (K[]) new Comparable[i];
        V [] vtemp = (V[]) new Object[i];
        for(int j=0;j<N;j++){
            ktemp[j] = keys[j];
            vtemp[j] = values[j];
        }
        keys = ktemp;
        values = vtemp;
    }

    public boolean contains(K key){
        return get(key)!=null;
    }

    public Iterable<K> keys(){
        List<K> list = new LinkedList<K>();
        for(int i = 0;i<N;i++){
            list.add(keys[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        BinarySearchSymbolTable<Character,Integer> binarySearchSymbolTable
                = new BinarySearchSymbolTable<>(5);
        String str = "searchexample";
        for(int i = 0;i<str.length();i++){
            binarySearchSymbolTable.put(str.charAt(i),i);
        }
        binarySearchSymbolTable.keys().forEach(k-> System.out.println(k+" "+binarySearchSymbolTable.get(k)));
    }

}
