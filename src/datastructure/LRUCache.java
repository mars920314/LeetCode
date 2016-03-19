package datastructure;
//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
import java.util.HashMap;
public class LRUCache {
    int capacity=0;
    int size=0;
    DLNode head;
    DLNode tail;
    HashMap<Integer,DLNode> map=new HashMap<Integer,DLNode>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        DLNode target=map.get(key);
        if(target==head)
        	;
        else if(target==tail){
            tail=tail.prev;
            tail.next=null;
            movehead(target);
        }else{
            target.prev.next=target.next;
            target.next.prev=target.prev;
            movehead(target);
        }
        return target.val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	DLNode target=map.get(key);
        	target.val=value;
            get(key);
        }
        else if(capacity<1)
            return;
        else if(size==0){
            head=new DLNode(value, key);
            tail=head;
            map.put(key,head);
            size++;
        }else{
            DLNode target=new DLNode(value, key);
            movehead(target);
            map.put(key,head);
            size++;
        }
        if(size>capacity){
            map.remove(tail.key);
            size--;
            tail=tail.prev;
            tail.next=null;
        }
        return;
    }
    
    void movehead(DLNode target){
        target.prev=null;
        target.next=head;
        head.prev=target;
        head=target;
    }
    public static void main(String[] args){
    	LRUCache L=new LRUCache(3);
    	//L.set(1,20000);
    	//System.out.print(L.get(1));
    }
}
class DLNode{
    int val;
    int key;
    DLNode next;
    DLNode prev;
    DLNode(int value, int key){
        this.val=value;
        this.key=key;
    }
}