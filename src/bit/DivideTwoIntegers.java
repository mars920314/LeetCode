package bit;
//Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        long dividendlong=Math.abs((long)dividend);
        long divisorlong=Math.abs((long)divisor);
        int res=0;
        long div=divisorlong;
        while(dividendlong>div){
            div=div<<1;
        }
        while(div>=divisorlong){
            if(dividendlong>=div){
                res=(res<<1)+1;
                dividendlong=dividendlong-div;
            }
            else
                res=(res<<1);
            div=div>>1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return res;
        else
            return -res;
    }

}
