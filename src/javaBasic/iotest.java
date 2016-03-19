package javaBasic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class iotest {
	public static void main(String[] args){
		System.out.print("typein words");
		BufferedReader sysin=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.print(sysin.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.print("typein words again");
		BufferedInputStream sysinag=new BufferedInputStream(System.in);
		byte[] b=new byte[16];
		try {
			int len=sysinag.read(b);
			System.out.print(new String(b,0,len));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ioimplement io=new ioimplement();
		io.rw_filestream("a");
	}

}

class ioimplement{
	public static String filename="C:/Users/mars/Desktop/io.txt";
	public void rw_filestream(String str){
		File file=new File(filename);
		try {
			FileInputStream in = new FileInputStream(file);
			byte[] b=new byte[1024];
			in.read(b);
			System.out.print(new String(b));
/*			int temp = 0;
			while ((temp = in.read()) != -1) {
				b[0]=(byte) temp;
				System.out.println(new String (b));
			}
*/			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			FileOutputStream out=new FileOutputStream(file);
			byte[] b=str.getBytes();
			out.write(b);
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}