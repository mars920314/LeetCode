package DfsBfs;
//Given a string that contains only digits 0-9 and a target value, return all possibilities to add operators +, -, or * between the digits so they evaluate to the target value.
//"123", 6 -> ["1+2+3", "1*2*3"] 	
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        ArrayList<String> res=new ArrayList<String>();
        LinkedList<Integer>  stack=new LinkedList<Integer>();
        if(num.length()!=0){
        	Integer c=num.charAt(0)-'0';
            stack.push(c);
            loop(num,target,1,stack,res,String.valueOf(c));
        }
        return res;
    }
    void loop(String num, int target, int index, LinkedList<Integer> stack, ArrayList<String> res, String str){
        if(index==num.length()){
            int sum=0;
            LinkedList<Integer> stackcopy=new LinkedList<Integer>(stack);
            while(!stackcopy.isEmpty())
                sum=sum+stackcopy.pop();
            if(sum==target){
                res.add(str);
            }
            return;
        }
        Integer c=num.charAt(index)-'0';
        //+
        stack.push(c);
        loop(num,target,index+1,stack,res,str+"+"+String.valueOf(c));
        //-
        stack.pop();
        stack.push(-c);
        loop(num,target,index+1,stack,res,str+"-"+String.valueOf(c));
        //*
        stack.pop();
        int a=stack.pop();
        stack.push(a*c);
        loop(num,target,index+1,stack,res,str+"*"+String.valueOf(c));
        stack.pop();
        stack.push(a);
    }
    public static void main(String[] args){
    	ExpressionAddOperators EAO=new ExpressionAddOperators();
    	System.out.print(EAO.addOperators("123", 6));
    }

}
