package test;

import java.util.Arrays;
import java.util.LinkedList;

public class ques14 {
	int[] solution(int[] array){
		int[] res=new int[array.length];
		for(int i=0;i<array.length;i++){
			res[i]=battle(array, i+1);
		}
		return res;
	}
	
	int battle(int[] array, int x){
		int max=Integer.MIN_VALUE;
		LinkedList<Integer> deque=new LinkedList<Integer>();
		int[] res=new int[array.length-x+1];
		for(int i=0; i< array.length;i++){
			if(i>x-1){
				res[i-x]=deque.poll();
				max=Math.max(res[i-x], max);
			}
			int buffer=0;
			while(!deque.isEmpty() && deque.peekLast()>array[i]){
				deque.removeLast();
				buffer++;
			}
			while(buffer>-1){
				deque.offer(array[i]);
				buffer--;
			}
		}
		res[res.length-1]=deque.poll();
		max=Math.max(res[res.length-1], max);
		return max;
	}
	public static void main(String[] args){
		ques14 Q=new ques14();
		int[] array={1,2,3,4,5,4,3,2,1,6};
		System.out.print(Arrays.toString(Q.solution(array)));
	}

}
