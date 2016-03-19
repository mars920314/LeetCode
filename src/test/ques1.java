package test;

public class ques1 {
	long count=0;
	long solution(long x){
		int[] row=new int[2];//1 stands for man;2 stands for female
		choose(x,row);
		return count;
	}
	void choose(long x, int[] row){
		if(x==0){
			if(row[0]==1 && row[1]==2)
				return;
			else{
				count++;
				return;
			}
		}
		if(row[0]==0){
			row[0]=1;
			choose(x-1,row);
			row[0]=2;
			choose(x-1,row);
			row[0]=0;
		}
		else if(row[1]==0){
			if(row[0]==1){
				row[1]=1;
				choose(x-1,row);
				row[1]=2;
				choose(x-1,row);
			}else if(row[0]==2){
				row[1]=2;
				choose(x-1,row);
			}
			row[1]=0;
		}else{
			if(row[0]==1 && row[1]==2){
				row[0]=row[1];
				row[1]=2;
				choose(x-1,row);
				row[0]=1;
				row[1]=2;
			}else{
				int tmp=row[0];
				row[0]=row[1];
				row[1]=1;
				choose(x-1,row);
				row[1]=2;
				choose(x-1,row);
				row[1]=row[0];
				row[0]=tmp;
			}
		}
	}
	public static void main(String[] args){
		ques1 Q=new  ques1();
		System.out.print(Q.solution(300));
	}

}
