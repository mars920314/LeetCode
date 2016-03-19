package string;

public class substring {
	public int strStr(String haystack, String needle) {
		int hlen = haystack.length();
		int nlen = needle.length();
		if (nlen == 0)
			return 0;
		if (hlen == 0)
			return -1;
		int hindex = 0;
		while (hindex < hlen - nlen + 1) {
			int nindex = 0;
			int tmpindex = hindex;
			while (nindex < nlen) {
				if (haystack.charAt(tmpindex) == needle.charAt(nindex)) {
					tmpindex++;
					nindex++;
				} else
					break;
				if (nindex == nlen)
					return hindex;
			}
			hindex++;
		}
		return -1;
	}

	public static void main(String[] args) {
		substring sub = new substring();
		System.out.print(sub.strStr("mississippi", "a"));
	}

}
