package list;
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
public class MinStack {
	node head;
    public void push(int x) {
        if(head==null){
        	head=new node(x);
        	head.min=x;
        }
        else{
        	node tmp=new node(x);
        	tmp.next=head;
        	tmp.min=Math.min(x, head.min);
        	head=tmp;
        }
    }

    public void pop() {
        if(head==null)
        	return;
        else
        	head=head.next;
    }

    public int top() {
    	if(head==null)
    		return Integer.MAX_VALUE;
    	else
    		return head.val;
    }

    public int getMin() {
        if(head==null)
        	return Integer.MAX_VALUE;
        else
        	return head.min;
    }
}
class node{
	int val;
	int min;
	node next;
	node(){
		
	}
	node(int x){
		this.val=x;
	}
}