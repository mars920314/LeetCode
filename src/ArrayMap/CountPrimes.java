package ArrayMap;
//Count the number of prime numbers less than a non-negative number, n.
import java.util.ArrayList;
public class CountPrimes {
	public int countPrimes(int n) {
		ArrayList<Integer> prime=new ArrayList<Integer>();
		for(int i=2;i<n;i++){
			boolean isPrime=true;
			int upbound=(int)Math.sqrt(i)+1;
			for(Integer j:prime){
				if(j>upbound)
					break;
				if(i%j==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime)
				prime.add(i);
		}
		return prime.size();
	}
	public static void main(String[] args){
		CountPrimes CP=new CountPrimes();
		System.out.print(CP.countPrimes(100));
	}

}
