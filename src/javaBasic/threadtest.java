package javaBasic;

public class threadtest {
	public static void main(String[] args){
		threadprint th =new threadprint("WWW");
		Thread th1 = new Thread(th);
		th1.start();
	}

}

class threadprint implements Runnable{
	String str=new String();
	public threadprint(String str){
		this.str=str;
	}
	public void run(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(str);
	}
}

