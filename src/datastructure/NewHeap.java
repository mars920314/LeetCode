package datastructure;

import java.util.ArrayList;
import java.util.Arrays;

//HeapMin
public class NewHeap {
	int maxsize;
	ArrayList<Integer> heap;
	int top;
	public NewHeap(int size){
		this.maxsize=size;
		heap=new ArrayList<Integer>(maxsize);
		top=0;
	}
	public void downheap(int i){
		int left=2*i+1;
		int right=2*i+2;
		int small=i;
		if(left<heap.size() && heap.get(left)<heap.get(small))
			small=left;
		if(right<heap.size() && heap.get(right)<heap.get(small))
			small=right;
		if(small!=i){
			int tmp=heap.get(i);
			heap.set(i,heap.get(small));
			heap.set(small,tmp);
			downheap(small);
		}
	}
	public void delete(int i){
		heap.set(i,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		downheap(i);
	}
	public void upheap(int i){
		if(i==0)
			return;
		int parent=(i-1)/2; 
		//System.out.println("print " + parent);
		if(heap.get(parent)>heap.get(i)){
			int tmp=heap.get(i);
			heap.set(i, heap.get(parent));
			heap.set(parent, tmp);
			upheap(parent);
		}
	}
	public void insert(int value){
		heap.add(value);
		upheap(heap.size()-1);
	}
	public void heapify(int[] array){
		for(int i=0;i<array.length;i++){
			insert(array[i]);
		}
	}
	public void printall(){
		for(int i=0;i<heap.size();i++)
			System.out.print(heap.get(i)+",");
	}
	public int[] sort(int[] array){
		int[] a=new int[array.length];
		heapify(array);
		System.out.println(heap.toString());
		for(int i=0;i<a.length;i++){
			a[i]=heap.get(0);
			delete(0);
		}
		return a;
	}

}
