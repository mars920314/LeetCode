package test;

public class ques4 {
	boolean solution(int n, boolean[] a){
		int len=a.length;
		for(int i=0;i<len/3;i++){
			if(a[i*3]?(a[i*3+1] || a[i+3+2]):(a[i*3+1] && a[i*3+2]))
				n=n-2;
		}
		for(int i=len/3*3;i<len;i++){
			if(a[i])
				n--;
		}
		return n<=0;
	}
	public static void main(String[] args){
		ques4 Q=new  ques4();
		boolean[] a={false,true,true,false};
		System.out.print(Q.solution(3,a));
	}

}
