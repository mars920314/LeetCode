package dynamicProgramming;
//Implement wildcard pattern matching with support for '?' and '*'.
public class WildcardMatching {
	//greedy
	public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                j++;
                mark = i;
           //��һ���ǹؼ���ƥ��s�е�ǰ�ַ���p�С�����������ַ������ƥ�䣬���ڵ�һ��if�д��������ƥ�䣬������Ƚ�s�е���һ���ַ���
            } else if (star != -1) {
                j = star + 1;
                i = ++mark;
            } else {
                return false;
            }
        }
       //����ڴ˴��������ġ���������Ϊ�����������һ��������������ͬ��
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }
	//recursive
	public boolean isMatch1(String s, String p) {
        int len=s.length();
        int plen=p.length();
        for(int i=0;i<len;i++){
            if(i>plen-1)
                return false;
            char pat=p.charAt(i);
            if(pat=='*'){
                while(i+1<plen && p.charAt(i+1)=='*')
                    i++;
                if(i==plen-1)
                    return true;
                boolean sub;
                for(int j=i;j<len;j++){
                    sub=isMatch(s.substring(j,len),p.substring(i+1,plen));
                    if(sub)
                        return true;
                }
                return false;
            }
            else if(pat=='?')
                continue;
            else
                if(pat!=s.charAt(i))
                    return false;
        }
        if(len!=plen)
            return false;
        else
            return true;
    }

}
