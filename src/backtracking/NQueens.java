package backtracking;
//wrong
//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle.
import java.util.List;
import java.util.ArrayList;
public class NQueens {
	public List<List<String>> solveNQueens1(int n) {
        char[][] chess=new char[n][n];
        int queens=n;
        ArrayList<List<String>> res=new ArrayList<List<String>>();
        fillinchess(chess, res, queens, n);
        return res;
    }
    void fillinchess(char[][] chess, ArrayList<List<String>> res, int queens, int n){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(chess[i][j]=='Q' || chess[i][j]=='.')
                    continue;
                if(queens>-1 && check(chess,i,j,n)){
                    chess[i][j]='Q';
                    queens--;
                    fillinchess(chess, res, queens, n);
                    queens++;
                    chess[i][j]=' ';
                }else{
	                chess[i][j]='.';
	                fillinchess(chess, res, queens, n);
	                chess[i][j]=' ';
                }
            }
        if(queens==0)
            addlist(chess, res);
    }
    void addlist(char[][] chess, ArrayList<List<String>> res){
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<chess.length;i++){
            String str=new String(chess[i]);
            list.add(str);
        }
        res.add(list);
    }
    boolean check(char[][] chess, int i, int j, int n){
        for(int checkrow=0;checkrow<n;checkrow++)
            if(chess[checkrow][j]=='Q')
                return false;
        for(int checkcol=0;checkcol<n;checkcol++)
            if(chess[i][checkcol]=='Q')
                return false;
        for(int x=1-n;x<n;x++)
            if(i+x>-1 && i+x<n && j+x>-1 && j+x<n && chess[i+x][j+x]=='Q')
                return false;
        for(int x=1-n;x<n;x++)
            if(i+x>-1 && i+x<n && j+x>-1 && j+x<n && chess[i+x][j+x]=='Q')
                return false;
        for(int x=1-n;x<n;x++)
            if(i-x>-1 && i-x<n && j+x>-1 && j+x<n && chess[i-x][j+x]=='Q')
                return false;
        return true;
    }
    
    
    //right solution
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        boolean[] isVisited =new boolean[n];
        permutation(n,new ArrayList<Integer>(),isVisited,res);
        return construct(res);
    }
    void permutation(int n, ArrayList<Integer> list, boolean[] isVisited, List<List<Integer>> res){
        if(list.size()==n){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i=0;i<n;i++){
            if(check(list,isVisited,i)){
                list.add(i);
                isVisited[i]=true;
                permutation(n,list,isVisited,res);
                list.remove(list.size()-1);
                isVisited[i]=false;
            }
        }
    }
    boolean check(ArrayList<Integer> list, boolean[] isVisited, int num){
        if(isVisited[num])
            return false;
        for(int i=0;i<list.size();i++){
            if(i-list.size()==list.get(i)-num)
                return false;
            if(list.size()-i==list.get(i)-num)
                return false;
        }
        return true;
    }
    List<List<String>> construct(List<List<Integer>> res){
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<res.size();i++){
            List<Integer> list=res.get(i);
            ArrayList<String> strlist=new ArrayList<String>();
            for(int j=0;j<list.size();j++){
                int n=list.get(j);
                String str="";
                for(int k=0;k<list.size();k++){
                    if(n==k)
                        str=str+"Q";
                    else
                        str=str+".";
                }
                strlist.add(str);
            }
            result.add(strlist);
        }
        return result;
    }
    public static void main(String[] args){
    	NQueens NQ=new NQueens();
    	System.out.print(NQ.solveNQueens(4));
    }
}
