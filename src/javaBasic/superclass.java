package javaBasic;

public class superclass {
	private int n;
	superclass(){
        System.out.println("SuperClass()");
    }
    superclass(int n){
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
class subclass extends superclass{
    private int n;
    
    subclass(){
        super(300);
        System.out.println("SuperClass");
        
    }
    subclass(int n){
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }
}