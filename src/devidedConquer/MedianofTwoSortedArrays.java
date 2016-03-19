package devidedConquer;
//There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. 
//The overall run time complexity should be O(log (m+n)).
public class MedianofTwoSortedArrays {
	//m==n
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		if(nums1.length==0)
			return 0;
		return findmedian(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
	}
	double median(int[] nums, int start, int end){
		int len=end-start+1;
		if(len%2==0)
			return (nums[start+(len-1)/2]+nums[start+(len-1)/2+1])/2;
		else
			return nums[start+len/2]; 
	}
	double findmedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2){
		int len1=end1-start1;
		int len2=end2-start2;
		if(len1==0)
			return (nums1[start1]+nums2[start2])/2;
		if(len1==1){
    		double a=Math.max(nums1[start1],nums2[start2]);
    		double b=Math.min(nums1[end1],nums2[end2]);
    		return(a+b)/2;
    	}
		double mid1=median(nums1, start1, end1);
		double mid2=median(nums2, start2, end2);
		if(mid1==mid2)
			return mid1;
		else if(mid1>mid2)
			return findmedian(nums1, start1, (len1+1-1)/2+1, nums2, (len2+1-1)/2-1, end2);
		else
			return findmedian(nums1, (len1+1-1)/2-1, end1, nums2, start1, (len2+1-1)/2+1);
	}
	public static void main(String[] args){
		int[] nums1={1,3,5,7,9};
		int[] nums2={0,2,4,6,8};
		MedianofTwoSortedArrays MTSA=new MedianofTwoSortedArrays();
		System.out.print(MTSA.findMedianSortedArrays(nums1, nums2));
	}

}
