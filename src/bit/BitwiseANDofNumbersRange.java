package bit;
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        int res=0;
        int bit=1;
        for(int i=0; i<32; i++){
            for(int x=m;x<=n;x++){
                if((x&bit)==0)
                    break;
                if(x==n)
                    res=res|bit;
            }
            bit=bit<<1;
        }
        return res;
    }
	public int rangeBitwiseAnd1(int m, int n) {
		while (n > m) {
	          n = n & n - 1;
	     }
	     return m & n;
	}
	public static void main(String[] args){
		BitwiseANDofNumbersRange BANR=new BitwiseANDofNumbersRange();
		System.out.print(BANR.rangeBitwiseAnd1(600000000, 2147483645));
	}

}
