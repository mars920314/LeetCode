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
    public void method() throws Exception{ // ���쳣�׳����ɵ�����������ķ���ȥ��������쳣,���main����Ҳ���쳣�׳����򽻸�Java�����������
        System.out.println("Hello World");
        // �׳��Զ����쳣
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