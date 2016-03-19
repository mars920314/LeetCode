package test;

public class ques7 {
	int solution(int n, int k, int T){
		int sum=0;
		int num=1;
		for(int count=0;T>0;count++){
			num=(num+count)%k;
			if(count%n==0){
				sum=sum+num;
				T--;
			}
		}
		return sum;
	}
	public static void main(String[] args){
		ques7 Q=new ques7();
		System.out.print(Q.solution(3, 13, 3));
	}

}
