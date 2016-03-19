package test;

public class ques3 {
	int solution(int n){
		int res=n;
		int Q=n/3;
		int R=n%3;
		int left=Q+R;
		res=res+Q;
		while(left>2){
			Q=left/3;
			R=left%3;
			left=Q+R;
			res=res+Q;
		}
		return res;
	}
	public static void main(String[] args){
		ques3 Q=new  ques3();
		System.out.print(Q.solution(11));
	}

}
