package list;
//You must use only standard operations of a queue
//which means only push to back, peek/pop from front, size, and is empty operations are valid.
import java.util.LinkedList;
public class ImplementStackusingQueues {
	LinkedList<Integer> list1=new LinkedList<Integer>();
	LinkedList<Integer> list2=new LinkedList<Integer>();
	public void push(int x) {
		if(list2.isEmpty())
    		list1.offer(x);
    	else
    	    list2.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(list1.isEmpty() && list2.isEmpty())
        	return;
        int tmp=Integer.MAX_VALUE;
        if(list2.isEmpty()){
        	while(!list1.isEmpty()){
            	if(tmp!=Integer.MAX_VALUE)
            		list2.offer(tmp);
            	tmp=list1.poll();
            }
        }else{
        	while(!list2.isEmpty()){
            	if(tmp!=Integer.MAX_VALUE)
            		list1.offer(tmp);
            	tmp=list2.poll();
            }
        }
    }

    // Get the top element.
    public int top() {
    	int top=Integer.MAX_VALUE;
    	if(list2.isEmpty()){
    		while(!list1.isEmpty()){
            	top=list1.poll();
            	list2.offer(top);
            }
    	}else{
    		while(!list2.isEmpty()){
            	top=list2.poll();
            	list1.offer(top);
            }
    	}
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list1.isEmpty() && list2.isEmpty();
    }
    
    public static void main(String[] args){
    	ImplementStackusingQueues ISQ=new ImplementStackusingQueues();
    	ISQ.push(1);
    	//ISQ.push(2);
    	ISQ.pop();
    	System.out.print(ISQ.top());
    }

}