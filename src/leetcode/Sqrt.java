package leetcode;

public class Sqrt {
	 public int mySqrt(int x) {
		if (x == 0) return 0;  
		double lastY = 0;  
		double y = 1;  
		while (y != lastY)  
		{  
		    lastY = y;  
		    y = (y + x / y) / 2;  
		}  
		return (int)(y);  
	 }
	 public int mySqrt1(int x) {
		 if(x<0) return -1;  
		 if(x==0) return 0;
		 int up=x;
	     int down=1;
	     int mid=(up+down)/2;
	     while(up>down){
	    	 if(x/mid>=mid && x/(mid+1)<mid+1)
	    		 return mid;
	    	 else if(x/mid<mid)
	             up=mid-1;
	         else
	             down=mid+1;
	         mid=(up+down)/2;
	     }
	     return mid;
	 }
	 public static void main(String[] args){
		 Sqrt S=new Sqrt();
		 System.out.print(S.mySqrt1(2));
	 }
}
