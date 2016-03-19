package string;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		int len = s.length();
		for (int ip1 = 1; ip1 < 4; ip1++)
			for (int ip2 = 1; ip2 < 4; ip2++)
				for (int ip3 = 1; ip3 < 4; ip3++)
					for (int ip4 = 1; ip4 < 4; ip4++)
						if (ip1 + ip2 + ip3 + ip4 == len
								&& isValid(s.substring(0, ip1))
								&& isValid(s.substring(ip1, ip1 + ip2))
								&& isValid(s.substring(ip1 + ip2, ip1 + ip2
										+ ip3))
								&& isValid(s.substring(ip1 + ip2 + ip3, len))) {
							String s1 = s.substring(0, ip1);
							if (isValid(s1)) {
								String s2 = s.substring(ip1, ip1 + ip2);
								if (isValid(s2)) {
									String s3 = s.substring(ip1 + ip2, ip1
											+ ip2 + ip3);
									if (isValid(s3)) {
										String s4 = s.substring(
												ip1 + ip2 + ip3, len);
										if (isValid(s4))
											list.add(s1 + "." + s2 + "." + s3
													+ "." + s4);
									}
								}
							}
						}
		return list;
	}

	boolean isValid(String s) {
		int len = s.length();
		int num = Integer.valueOf(s);
		if (num > -1 && num < 256) {
			if (len != 1 && s.charAt(0) == '0')
				return false;
			else
				return true;
		} else
			return false;
	}

}
