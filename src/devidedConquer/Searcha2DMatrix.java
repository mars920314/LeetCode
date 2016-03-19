package devidedConquer;
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
public class Searcha2DMatrix {
	//Integers in each row are sorted from left to right.
	//The first integer of each row is greater than the last integer of the previous row.
	public boolean searchMatrix1(int[][] matrix, int target) {
		if(matrix.length==0)
			return false;
		int low, midrow=0, midcol=0, high;
		low=0;
		high=matrix.length-1;
		int len=matrix[0].length-1;
		while(low<=high){
			midrow=(high+low)/2;
			if(target>matrix[midrow][len])
				low=midrow+1;
			else if(target<matrix[midrow][len])
				high=midrow-1;
			else{
				return true;
			}
		}
		if(target>matrix[midrow][len] && midrow<matrix.length-1)
			midrow=midrow+1;
		low=0;
		high=matrix[0].length-1;
		while(low<=high){
			midcol=(high+low)/2;
			if(target>matrix[midrow][midcol])
				low=midcol+1;
			else if(target<matrix[midrow][midcol])
				high=midcol-1;
			else{
				return true;
			}
		}
		return false;
	}
	//Integers in each row are sorted in ascending from left to right.
	//Integers in each column are sorted in ascending from top to bottom.
	public boolean searchMatrix2(int[][] matrix, int target) {
		return true;
	}
	public static void main(String[] args){
		int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[][] matrix1={{1,1}};
		int target=10;
		Searcha2DMatrix SM=new Searcha2DMatrix();
		System.out.print(SM.searchMatrix1(matrix1, target));
	}

}
