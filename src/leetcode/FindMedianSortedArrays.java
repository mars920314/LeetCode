package leetcode;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
public class FindMedianSortedArrays {
	public static  void main(String[] args){
		int[] nums1={1,3,5,7,9};
		int[] nums2={0,2,4,6,8};
		FindMedianSortedArrays median=new FindMedianSortedArrays();
		System.out.print(median.findMedianSortedArrays(nums1,nums2));
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return(FindMedianTwoArray(nums1,0,nums1.length-1,nums2,0,nums2.length-1));
    }
    public double FindMedianTwoArray(int[] nums1,int heads1,int tails1,int[] nums2,int heads2,int tails2){
    	double m1=findmedian(nums1,heads1,tails1);
    	double m2=findmedian(nums2,heads2,tails2);
    	int lens1=tails1-heads1;
    	int lens2=tails2-heads2;
    	if(lens1==0)
    		return(nums1[heads1]+nums2[heads2])/2;
    	if(lens1==1){
    		double a=Math.max(nums1[heads1],nums2[heads2]);
    		double b=Math.min(nums1[tails1],nums2[tails2]);
    		return(a+b)/2;
    	}
    	if(m1==m2)
    		return m1;
    	else if(m1>m2)
    		return(FindMedianTwoArray(nums1,heads1,heads1+(int)Math.ceil(lens1/2),nums2,heads2+(int)Math.floor(lens2/2),tails2));
    	else
    		return(FindMedianTwoArray(nums1,heads1+(int)Math.floor(lens1/2),tails1,nums2,heads2,heads2+(int)Math.ceil(lens2/2)));
    }
    public double findmedian(int[] num,int head,int tail){
    	int len=tail-head+1;
        if(len%2==0)
            return((num[head+(len-1)/2]+num[head+(len-1)/2+1])/2);
        else
        	return(num[head+len/2]);
    }
}
