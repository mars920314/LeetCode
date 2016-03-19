package javaBasic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class exceptiontest extends Exception{
	public static void main(String args[]) throws IOException{
		BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
		String inputdata=null;
		try {
			inputdata=indata.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ExceptionTest1{
    public void method() throws Exception{ // 将异常抛出，由调用这个方法的方法去处理这个异常,如果main方法也将异常抛出，则交给Java虚拟机来处理
        System.out.println("Hello World");
        // 抛出自定义异常
        throw new Exception();
    }
    public static void main(String[] args){
        ExceptionTest1 test = new ExceptionTest1();
        try{
            test.method();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Welcome");
        }
    }
}

class ExceptionTest2
{
	public void method(String str) throws Exception{
		if(str.equals(null)){
			throw new Exception();
		}
		else{
			System.out.println(str);
		}
	}
	public static void main(String[] args) throws Exception{
		ExceptionTest2 test = new ExceptionTest2();
		test.method(null);
	}
}