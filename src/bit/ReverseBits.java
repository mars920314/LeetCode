package bit;
//Reverse bits of a given 32 bits unsigned integer.
public class ReverseBits {
	public int reverseBits(int n) {
		int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = (reversed << 1) | (n & 1);
            n = (n >> 1);
        }
        return reversed;
	}
	public static void main(String[] args){
		ReverseBits RB=new ReverseBits();
		System.out.print(RB.reverseBits(2));
	}

}
