package test;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class ques11 {
	PriorityQueue solution(ArrayList<com> list, int k){
		PriorityQueue<com> heap=new PriorityQueue<com>(k);
		for(int i=0;i<list.size();i++){
			if(i<k)
				heap.offer(list.get(i));
			else{
				if(list.get(i).sale>heap.peek().sale){
					heap.poll();
					heap.offer(list.get(i));
				}
			}
		}
		return heap;
	}

}
class com{
	long id;
	long sale;
	com(long id, long sale){
		this.id=id;
		this.sale=sale;
	}
}
