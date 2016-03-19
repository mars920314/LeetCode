package test;

public class ques2 {
	long solution(int n, int m, int k){
		int[] nums=new int[n];
		long count=0;
		while(nums[m-1]!=k){
			count++;
			if(count%7==0){
				int remain=(int)count%(2*n-2);
				if(remain==0)
					nums[1]++;
				else if(remain<n)
					nums[remain-1]++;
				else
					nums[2*n-1-remain]++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		ques2 Q=new  ques2();
		System.out.print(Q.solution(4,2,1));
		System.out.print(Q.solution(5,3,2));
	}

}
