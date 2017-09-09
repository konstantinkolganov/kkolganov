package ru.job4j;

public class ContainString {
	
	private boolean result;
	
	public boolean contains(String origin, String sub) {
		
		char[] originBuf = new char[origin.length()];
		char[] subBuf = new char[sub.length()];
		
		origin.getChars(0, origin.length(), originBuf, 0);
		sub.getChars(0, sub.length(), subBuf, 0);
		
		for (int j = 0; j < origin.length(); j++) {
			if (originBuf[j] == subBuf[0]) {
				boolean[] bool = new boolean[sub.length()];
				for (int i = 0; i < bool.length; i++) {
					bool[i] = (originBuf[j + i] == subBuf[i]);
				}
				for (int a = 0; a < bool.length; a++) {
					this.result |= bool[a];
				}
				if (this.result == true) {
					break;
				}
			}
		}
		return this.result;
	}
}