package dynamicProgramming;

public class Candy {
	//greedy
	public int candy(int[] ratings) {
        if(ratings.length==0)
            return 0;
        int len=ratings.length;
        int[] left=new int[len];
        left[0]=1;
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        int[] right=new int[len];
        right[len-1]=Math.max(1,left[len-1]);
        int res=right[len-1];
        for(int i=len-2;i>-1;i--){
            if(ratings[i]>ratings[i+1])
                right[i]=Math.max(right[i+1]+1,left[i]);
            else
                right[i]=Math.max(1,left[i]);
            res=res+right[i];
        }
        return res;
    }
	//dynamic programming
	public int candy1(int[] ratings) {
        if(ratings.length==0)
            return 0;
        int[] candy=new int[ratings.length];
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                candy[i]=candy[i-1]+1;
            else if(ratings[i]==ratings[i-1])
                candy[i]=1;
            else{
                candy[i]=1;
                if(candy[i-1]<2){
                    int j=i-1;
                    while(j>0){
                        candy[j]++;
                        if(ratings[j]>=ratings[j-1])
                            break;
                        else
                            if(candy[j]<candy[j-1])
                                break;
                        j--;
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<ratings.length;i++)
            sum=sum+candy[i];
        return sum;
    }

}
