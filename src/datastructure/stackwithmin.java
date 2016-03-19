package datastructure;

import java.util.Stack;

//modified stack in push and pop, which add min() to return min element in O(1) time
public class stackwithmin {
	public Stack<stackdoubleelement> stackdata;
	public void push(int a){
		stackdoubleelement element=new stackdoubleelement(a,stackdata.peek().minvalue);
		if(stackdata.peek().minvalue>a){
			element.minvalue=a;
		}
		stackdata.push(element);
	}
	public int pop(){
		return stackdata.pop().value;
	}
	public int peek(){
		return stackdata.peek().value;
	}
	public int min(){
		return stackdata.peek().minvalue;
	}
}
class stackdoubleelement{
	int value;
	int minvalue;
	stackdoubleelement(int value, int minvalue){
		this.value=value;
		this.minvalue=minvalue;
	}
}