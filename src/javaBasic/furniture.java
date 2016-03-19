package javaBasic;

public class furniture {
	public String type=null;
	public String material=null;
	Integer fire=null;
	Integer weight=null;
	getprice price=new getprice(2009, true, false);
	furniture(String type, String material){
		this.type=type;
		this.material=material;
		if(this.material=="wood")
			fire=500;
		else if(this.material=="glass")
			fire=1000;
		if(this.type=="table")
			this.weight=50;
		else if(this.type=="chair")
			this.weight=20;
		price.calculate(1000);
	}
	furniture(String type, String material, int p){
		this.type=type;
		this.material=material;
		if(this.material=="wood")
			fire=500;
		else if(this.material=="glass")
			fire=1000;
		if(this.type=="table")
			this.weight=50;
		else if(this.type=="chair")
			this.weight=20;
		price.calculate(p);
	}
	public static void main(String[] args){
		furniture glasschair=new furniture("chair", "glass");
		System.out.println(glasschair.fire);
		System.out.println(glasschair.weight);
		System.out.println(glasschair.price.curprice);
	}

}
class getprice{
	int year;
	boolean isnew;
	boolean ispolished;
	int curprice;
	getprice(int year, boolean isnew, boolean ispolished){
		this.year=year;
		this.isnew=isnew;
		this.ispolished=ispolished;
	}
	int calculate(int origprice){
		this.curprice=origprice;
		if(!isnew)
			this.curprice=(int) (this.curprice*0.8);
		if(ispolished)
			this.curprice=(int) (this.curprice*1.2);
		if(year<2010)
			this.curprice=(int) (this.curprice*0.8);
		return this.curprice;
	}
}
