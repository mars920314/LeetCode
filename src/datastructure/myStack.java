package datastructure;
//failed
public class myStack {
	int top;
	int maxsize;
	mynode topnode;
	myStack(int maxsize){
		this.maxsize=maxsize;
		top=-1;
	}
	public void push(int a){
		if(top==-1){
			topnode=new mynode(a);
			topnode.size=1;
			top=1;
		}else{
			topnode.nextnode=new mynode(a);
			top++;
		}
		
		//top.prenode=peek();
	}
	public int peek(){
		return 0;
		
	}

}

class mynode{
	int size;
	int value;
	mynode nextnode;
	mynode(int value){
		this.value=value;
	}
}