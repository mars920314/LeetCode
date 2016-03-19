package test;

public class ques9 {
	int solution(String str){
		int res=0;
		int year=Integer.parseInt(str.substring(0,4));
		int month=Integer.parseInt(str.substring(5,7));
		int date=Integer.parseInt(str.substring(8,10));
		if(year>2015){
			res=res+(year-2016)*365+(year-2016+3)/4;
			res=res+calmonth(1,month);
			res=res+date;
			res=res+13+30+31;
			if((year-2016)%4==0 && month>2)
				res=res+1;
		}else if(month>10){
			res=res+calmonth(11,month);
			res=res+date;
			res=res+13;
		}else{
			res=res+date-18;
		}
		return res;
	}
	int calmonth(int start, int end){
		int res=0;
		for(int i=start;i<end;i++){
			switch (i){
				case 1:res=res+31;break;
				case 2:res=res+28;break;
				case 3:res=res+31;break;
				case 4:res=res+30;break;
				case 5:res=res+31;break;
				case 6:res=res+30;break;
				case 7:res=res+31;break;
				case 8:res=res+31;break;
				case 9:res=res+30;break;
				case 10:res=res+31;break;
				case 11:res=res+30;break;
				case 12:res=res+31;break;
				default: break;
			}
		}
		return res;
	}

}
