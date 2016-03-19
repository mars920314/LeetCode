package leetcode;
//Implement pow(x, n)
public class Pow {
    public double pow(double x, int n) {
    	if(n<0)
    		return 1/pow(x,(double)(-n));
        if(n>0)
        	return pow(x,(double)n);
        else
        	return 1;
    }
    public double pow(double x, double n) {
    	if(n==1)
        	return x;
    	if(n==0)
    		return 1;
        int a=(int)Math.ceil(n/2);
        int b=(int)Math.floor(n/2);
        double result=pow(x,a)*pow(x,b);
        return result;
    }
    public static void main(String[] args){
    	Pow count=new Pow();
    	//System.out.print(count.pow2(3,4));
    	System.out.print(count.pow2(-1,-2147483647));
    }
//another method
    public double pow2(double x,int n){
    	if(n==0)
    		return 1;
    	else if(n<0){
    		double sub=pow2(x,(-n));
    		if(sub==0)
    			return Integer.MAX_VALUE;
    		else
    			return 1/sub;
    	}
    	else{
    		int a=(int) n/2;
    		double sub=pow2(x, a);
    		if(n%2==1)
    			return sub*sub*x;
    		else
    			return sub*sub;
    	}
    }
    //consider more corner case
    public double myPow(double x, int n) {
        if(n<0){
            if(x==0)
                return 0;
            if(n==Integer.MIN_VALUE)
                return 1/(myPow(x,Integer.MAX_VALUE)*x);
            return 1/myPow(x,-n);
        }else if(n==0)
            return 1;
        else if(n==1)
            return x;
        else{
            double sub=myPow(x,n/2);
            if(n%2==0)
                return sub*sub;
            else
                return sub*sub*x;
        }
    }
}
