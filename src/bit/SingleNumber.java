package bit;

public class SingleNumber {
	//Given an array of integers, every element appears twice except for one. Find that single one.
	public int singleNumber(int[] nums) {
		int a=0;
		for(int i=0;i<nums.length;i++)
			a=a ^ nums[i];
		return a;
	}
	//Given an array of integers, every element appears three times except for one. Find that single one.
	public int singleNumber1(int[] nums) {
		int a=0;
		for(int i=0;i<32;i++){
			int b=0;
			for(int j=0;j<nums.length;j++){
				b=b+((nums[j]>>i) & 1);
			}
			a=a | ((b%3)<<i);
		}
		return a;
	}
	public static void main(String[] args){
		SingleNumber SN=new SingleNumber();
		int[] nums={4,4,7,4};
		int[] nums1={-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
		System.out.print(SN.singleNumber1(nums1));
	}
}
