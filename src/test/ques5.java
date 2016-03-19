package test;

public class ques5 {
	String solution(String str){
		int maxlen=0;
		int maxsum=0;
		String maxstr="";
		int start=0;
		int end=0;
		boolean isnum=false;
		for(int i=0;i<str.length();i++){
			while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
				if(!isnum){
					start=i;
					isnum=true;
				}
				end=i;
				i++;
			}
			if(isnum){
				isnum=false;
				i--;
				if(maxlen<(end-start)){
					maxlen=end-start;
					maxstr=str.substring(start,end+1);
					maxsum=0;
					for(int j=start;j<end+1;j++){
						maxsum=maxsum+(str.charAt(i)-'0');
					}
				}else if(maxlen==(end-start)){
					int tmpsum=0;
					for(int j=start;j<end+1;j++){
						tmpsum=tmpsum+(str.charAt(i)-'0');
					}
					if(tmpsum>maxsum){
						maxlen=end-start;
						maxstr=str.substring(start,end+1);
						maxsum=tmpsum;
					}
				}
			}
		}
		return maxstr;
	}
	public static void main(String[] args){
		ques5 Q=new  ques5();
		System.out.print(Q.solution("abcd12345ed125ss123456789"));
	}

}
