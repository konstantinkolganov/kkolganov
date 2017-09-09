package ru.job4j;

public class ContainString {
	
	public boolean contains(String origin, String sub) {
		
		boolean result = true;
		
		char[] originBuf = origin.toCharArray();
		char[] subBuf = sub.toCharArray();
		
		boolean[] bool = new boolean[sub.length()];
		
		for (int j = 0; j < originBuf.length; j++) {
			if (originBuf[j] == subBuf[0]) {
				for (int i = 0; i < bool.length; i++) {
					bool[i] = (originBuf[j + i] == subBuf[i]);
					result &= bool[i];
				}
				if (result == true) {
					break;
				}
			}
		}
		return result;
	}
}