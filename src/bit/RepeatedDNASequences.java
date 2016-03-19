package bit;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list=new ArrayList<String>();
		if(s.length()<10)
			return list;
		int sum=0;
		HashMap<Integer, Integer> bits=new HashMap<Integer, Integer>();
		for(int i=0;i<9;i++)
			sum=(sum | trans(s.charAt(i)))<<2;
		int a=Integer.MAX_VALUE>>11;
		for(int i=9;i<s.length();i++){
			sum=(sum | trans(s.charAt(i)));
			sum=sum & a;
			if(bits.containsKey(sum)){
				String str=s.substring(i-9,i+1);
				if(!list.contains(str))
					list.add(str);
			}
			else
				bits.put(sum, i);
			sum=sum<<2;
		}
		return list;
	}
	int trans(char bit){
		int a=0;
		switch(bit){
		case 'A': a=0;break;
		case 'C': a=1;break;
		case 'G': a=2;break;
		case 'T': a=3;break;
		}
		return a;
	}
	public List<String> findRepeatedDnaSequences1(String s) {
        List<String> list=new ArrayList<String>();
        HashSet<Integer> set=new HashSet<Integer>();
		if(s.length()<10)
			return list;
        int num=0;
        for(int i=0;i<10;i++)
            num=(num<<2)|trans(s.charAt(i));
        set.add(num);
        int a=Integer.MAX_VALUE>>11;
        for(int i=10;i<s.length();i++){
            num=((num<<2)|trans(s.charAt(i)))&a;
            if(set.contains(num)){
                String str=s.substring(i-9,i+1);
				if(!list.contains(str))
					list.add(str);
            }else
                set.add(num);
        }
        return list;
    }
	public static void main(String[] args){
		RepeatedDNASequences RDS=new RepeatedDNASequences();
		String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s1="GAGAGAGAGAGA";
		System.out.println(RDS.findRepeatedDnaSequences1(s1));
	}

}
