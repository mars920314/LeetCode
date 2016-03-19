package string;

//Given two numbers represented as strings, return multiplication of the numbers as a string.
//Note: The numbers can be arbitrarily large and are non-negative.
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] bit = new int[len1 + len2];
		for (int i = len1 - 1; i > -1; i--)
			for (int j = len2 - 1; j > -1; j--)
				// bit[i+j]=bit[i+j]+Integer.valueOf(num1.charAt(i))*Integer.valueOf(num2.charAt(j));
				bit[len1 - 1 - i + len2 - 1 - j] = bit[len1 - 1 - i + len2 - 1
						- j]
						+ (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
		String res = "";
		for (int k = 0; k < len1 + len2; k++) {
			int x = bit[k];
			if (k + 2 < len1 + len2)
				bit[k + 2] = bit[k + 2] + x / 100;
			if (k + 1 < len1 + len2)
				bit[k + 1] = bit[k + 1] + (x - (x / 100) * 100) / 10;
			bit[k] = x % 10;
			res = bit[k] + res;
		}
		for (int k = 0; k < len1 + len2; k++)
			if (res.charAt(k) != '0')
				return res.substring(k, len1 + len2);
		return "0";
	}

	public static void main(String[] args) {
		MultiplyStrings MS = new MultiplyStrings();
		System.out.print(MS.multiply("375", "97"));
	}

}
