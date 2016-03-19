package datastructure;

public class NewStack {
	Object[] data;
	int maxsize;
	int top;
	public NewStack(int maxsize){
		this.maxsize=maxsize;
		data=new Object[maxsize];
		top=-1;
	}
	public int getSize(){
		return maxsize;
	}
	public int getElementCount(){
		return top;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top+1==maxsize;
	}
	public boolean push(Object data){
		if(isFull()){
			return false;
		}
		this.data[++top]=data;
		return true;
	}
	public Object pop() throws Exception{
		if(isEmpty()){
			throw new  Exception("empty");
		}
		return(this.data[--top]);
	}
	public Object peek(){
		return this.data[top];
	}

}
