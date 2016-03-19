package test;

public class ques6 {
	int solution(int l, int r, int m){
		//r<=2000000;
		System.out.print(Integer.MAX_VALUE);
		int res=0;
		for(int i=l;i<=r;i++){
			int count=0;
			int num=i;
			for(int bit=0;bit<21;bit++){
				if((num&1)==1)
					count++;
				num=num >> 1;
			}
			if(count==m)
				res++;
		}
		if(res==0)
            return -1;
		return res;
	}
	public static void main(String[] args){
		ques6 Q=new ques6();
		System.out.print(Q.solution(1, 4, 2));
	}

}