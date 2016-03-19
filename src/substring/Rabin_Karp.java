package substring;

public class Rabin_Karp {
	
	//search substring within ASCii 7 bits
	public static int substring(String T, String P){
		double P_sum=0;
		double T_sum=0;
		for(int i=0; i<P.length();i++){
			P_sum=P_sum+P.charAt(i)*Math.pow(10, i);
		}
		double P_rem=P_sum%129;	//129 is the prime number
		for(int j=0; j<P.length();j++){
			T_sum=T_sum+T.charAt(j)*Math.pow(10, j);
		}
		for(int i=0; i<T.length()-P.length();i++){
			double T_rem=T_sum%129;
			if(T_rem==P_rem){
				if(P.equals(new String(T.getBytes(),i,P.length())))
					return i;
			}
			T_sum=(T_sum-T.charAt(i))/10+T.charAt(i+P.length())*Math.pow(10, P.length()-1);
			System.out.println(T_sum);
		}
		return -1;
	}
	
	public static void main(String[] args){
		String T=new String("abcdefg");
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
