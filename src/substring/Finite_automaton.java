package substring;
//not complete
import java.util.ArrayList;

public class Finite_automaton {
	public static int substring(String T, String P){
		int[][] tran=new int[P.length()+1][128];
		//ArrayList<String[]> array=new ArrayList();
		tran=tran_func(P);
		
		int state=0;
		for(int i=0;i<T.length();i++){
			//System.out.println(state);
			state=tran[state][(int)(T.charAt(i))];
			if(state==P.length())
				return i;
		}
		return -1;
		
	}
	
	private static int[][] tran_func(String P){
		int[][] tran=new int[P.length()+1][128];
		for(int q=0; q<P.length()+1;q++){
			for(int cha=0;cha<128;cha++){
				int k=P.length();
				if((q+1)<P.length())
					k=q+1;
				for(;k>0;k--){
					//System.out.println("k="+k);
					//System.out.println("q="+q);
					if(suffix(new String(P.getBytes(),0,k),new String(P.getBytes(),0,q),(char)(cha)))
						break;			
				}
				tran[q][cha]=k;
				if(cha==127)
					System.out.println(k);
				else
					System.out.print(k);
			}
		}
		return tran;
	}
	
	private static boolean suffix(String Pfix, String Pall, char cha){
		if(Pfix.charAt(Pfix.length()-1)==cha){
			for(int loop=2;loop<Pfix.length()+1;loop--){
				if(Pfix.charAt(Pfix.length()-loop)!=Pall.charAt(Pall.length()-loop+1))
					return false;
			}
			return true;
		}else
			return false;
	}
	
	public static void main(String[] args){
		String T=new String("ababababcdefg");
		String P=new String("cd");
		int i=Finite_automaton.substring(T, P);
		if(i==-1)
			System.out.print("not found");
		else{
			String padding=" ";
			for(;i>1;i--){
				padding=padding.concat(" ");
			}
			System.out.println(T);
			System.out.println(padding+P);
		}
	}

}
