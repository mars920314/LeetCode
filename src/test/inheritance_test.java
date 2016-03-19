package test;

public class inheritance_test {
	public static void main(String args[]){
		vehicle sedan=new vehicle();
		System.out.println(sedan.wheels);
		sedan.wheels=8;
		vehicle truck=new vehicle();
		System.out.println(truck.wheels);
		train train1=new train("cargo");
		train1.color="red";
	}

}
class vehicle{
	static int wheels=4;
	private String type;
	public String color;
	vehicle(){
		//若无此无参构造函数，则需要在之类构造函数里加	super(type);
	}
	vehicle(String type){
		this.type=type;
	}
	
	String gettype(){
		return this.type;
	}
	void settype(String type){
		this.type=type;
	}
}

class train extends vehicle{
	String type;
	//父类的构造器调用以及初始化过程一定在子类的前面。由于train类的父类是vehicle类，所以vehicle类先进行初始化static等，然后再执行vehicle类的构造器。接着才是对子类train进行初始化，最后执行train的构造器。
	train(String type){
		//super(type);
		this.type=type;
	}
	//子类覆盖父类的方法，必须有同样的参数返回类型
	String gettype(){
		return this.type;
	}
}