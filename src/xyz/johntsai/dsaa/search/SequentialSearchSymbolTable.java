package xyz.johntsai.dsaa.search;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by JohnTsai on 16/7/11.
 * 顺序查找 基于无序链表
 */
public class SequentialSearchSymbolTable<K extends Comparable<K>,V> {
    private Node head;
    private class Node{
        K key;
        V value;
        Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 查找给定的键,返回相关联的值
     * 命中返回值,未命中返回null
     * @param key
     * @return
     */
    public V get(K key){
        Node temp = head;
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 查找给定的键,若有值则更新反之则新增节点
     * @param key
     * @param value
     */
    public void put(K key,V value){
        if(value==null){
            delete(key);
            return;
        }
        Node temp = head;
        while(temp!=null){
            if(key.equals(temp.key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        head = new Node(key,value,head);
    }

    /**
     * 获取符号表的大小
     * @return
     */
    public int size(){
        Node temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 获取键的集合
     * @return
     */
    public Iterable<K> keys(){
        List<K> keys = new LinkedList<>();
        Node temp = head;
        while (temp!=null){
            keys.add(temp.key);
            temp = temp.next;
        }
        return keys;
    }

    /**
     * 查找给定键的节点,找到则删除
     * @param key
     */
    public void delete(K key){
        Node temp = head;
        //dummy head
        Node dummy = new Node(null,null,head);
        Node pre = dummy;
        while (temp!=null){
            if(temp.key.equals(key)){
                pre.next = temp.next;
                break;
            }
            pre = pre.next;
            temp = temp.next;
        }
        head = dummy.next;
    }

    public static void main(String[] args) {
        SequentialSearchSymbolTable<Character,Integer> table =
                new SequentialSearchSymbolTable<>();
        String test = "searchexample";
        for(int i = 0;i<test.length();i++){
            table.put(test.charAt(i),i);
        }
        table.keys().forEach(k-> System.out.println("key:"+k+" value:"+table.get(k)));
    }

}
