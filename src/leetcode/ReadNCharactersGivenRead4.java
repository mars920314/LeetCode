package leetcode;
//Question 15/16, page 30
public class ReadNCharactersGivenRead4 {
	//The read function will only be called once for each test case.
	/**
	* @param buf Destination buffer
	* @param n Maximum number of characters to read
	* @return The number of characters read
	*/
	public int read(char[] buf, int n) {
		char[] buffer=new char[4];
		boolean eof=false;
		int readbytes=0;
		while(!eof && readbytes<n){
			int readonce=read4(buffer);
			if(readonce<4)
				eof=true;
			int size=Math.min(readonce, n-readbytes);
			System.arraycopy(buffer /*src*/, 0 /*srcPos*/, buf /*dest*/, readbytes /*destPos*/, size /*length*/);
			readbytes=readbytes+size;
		}
		return readbytes;
	}
	public int read4(char[] buffer){
		return buffer.length;
	}
}

class ReadNCharactersGivenRead4more {
	//The read function will only be called more than once for each test case.
	/**
	* @param buf Destination buffer
	* @param n Maximum number of characters to read
	* @return The number of characters read
	*/
	private char[] buffer=new char[4];
	int offset;
	public int read(char[] buf, int n) {
		boolean eof=false;
		int readbytes=0;
		int readonce=0;
		while(!eof && readbytes<n){
			if(offset==0){
				readonce=read4(buffer);
				if(readonce<4)
					eof=true;
			}
			else
				readonce=buffer.length-offset;
			int size=Math.min(readonce, n-readbytes);
			System.arraycopy(buffer /*src*/, offset /*srcPos*/, buf /*dest*/, readbytes /*destPos*/, size /*length*/);
			offset=(offset+size)%buffer.length;
			readbytes=readbytes+size;
		}
		return readbytes;
	}
	public int read4(char[] buffer){
		return buffer.length;
	}
	
}