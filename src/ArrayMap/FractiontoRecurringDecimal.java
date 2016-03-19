package ArrayMap;
//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
import java.util.ArrayList;
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		boolean neg=false;
		boolean loop=false;
		long num = numerator, den = denominator;
		if(num<0 && den>0){
			neg=true;
			num=-num;
		}
		if(num>0 && den<0){
			neg=true;
			den=-den;
		}
		ArrayList<Long> remainderarray=new ArrayList<Long>();
		long prequotient=num/den;
		long remainder=num%den;
		String res="";
		while(remainder!=0){
			if(remainderarray.contains(remainder)){
				loop=true;
				break;
			}
			remainderarray.add(remainder);
			remainder=remainder*10;
			long quotient=remainder/den;
			remainder=remainder%den;
			res=res+quotient;
		}
		if(loop){
			int i=remainderarray.indexOf(remainder);
			res=res.substring(0,i)+"("+res.substring(i,res.length())+")";
		}
		if(res=="")
			res=prequotient+res;
		else
			res=prequotient+"."+res;
		if(neg)
			res="-"+res;
		return res;
	}
	public static void main(String[] args){
		FractiontoRecurringDecimal FRD=new FractiontoRecurringDecimal();
		System.out.print(FRD.fractionToDecimal(4, 7));
		System.out.print(FRD.fractionToDecimal(-2147483648, 1));
	}

}
