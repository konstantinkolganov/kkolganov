package ru.job4j.office;

import java.util.Comparator;

/**
* Класс OfficeComparator. Компаратор, сортирующий имена подразделений в порядке убывания.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 20.11.2017
* @version 2.0
*/

public class OfficeComparator implements Comparator<String> {
/**
* Класс OfficeComparator.
*/
/**
* Метод compare.
* @param str1 Первая строка.
* @param str2 Вторая строка.
* @return Если первая больше, то 1, если вторая - 2, если равны - 0.
*/
	public int compare(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int result = 0;
		int eq;
		String tmp;
		if (len1 > len2) {
			tmp = str1.substring(0, len2);
			eq = tmp.compareTo(str2);
			if (eq < 0) {
				result = 1;
			} else if (eq == 0) {
				result = 1;
			} else {
				result = -1;
			}
		}
		if (len1 < len2) {
			tmp = str2.substring(0, len1);
			eq = str1.compareTo(tmp);
			if (eq < 0) {
				result = 1;
			} else if (eq == 0) {
				result = -1;
			} else {
				result = -1;
			}
		}
		if (len1 == len2) {
			result = str2.compareTo(str1);
		}
		return result;
	}
}