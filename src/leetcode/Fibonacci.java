package leetcode;

public class Fibonacci {
	//recursive
	public long fibonacci1(int n){
		if(n<2)
			return n;
		return fibonacci1(n-1)+fibonacci1(n-2);
	}
	//tail recursive, use less stack
	public long fibonacci2(int n,int ret1,int ret2){
		if(n==0)
			return ret1;
		return fibonacci2(n-1,ret2,ret1+ret2);
	}
	//dp
	public long fibonacci(int n){
		if(n<2)
			return n;
		long[] fib=new long[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<n+1;i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib[n];
	}
	//recursive
	public long facttail(int n){
		//return(n == 1) ? 1 : n * facttail(n - 1);
		if(n==1)
			return 1;
		else
			return n*facttail(n-1);
	}
	//tail recursive, use less stack
	public long facttail1(int n, int a){
		//return(n == 1) ? a : facttail(n - 1, a * n);
		if(n==1)
			return a;
		else
			return facttail1(n-1, a*n);
	}
	
	public static void main(String[] args){
		Fibonacci F=new Fibonacci();
		int n=45;
		long a=System.currentTimeMillis();
		System.out.println(F.fibonacci1(n));
		long b=System.currentTimeMillis();
		System.out.println(F.fibonacci2(n,0,1));
		long c=System.currentTimeMillis();
		System.out.println(F.fibonacci(n));
		long d=System.currentTimeMillis();
		System.out.println(b-a);
		System.out.println(c-b);
		System.out.println(d-c);
	}

}
