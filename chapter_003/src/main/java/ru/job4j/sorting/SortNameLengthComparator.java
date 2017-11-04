package ru.job4j.sorting;

import java.util.Comparator;
/**
* Класс SortNameLengthComparator. Компаратор для сортировки элементов по длине имени.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 04.11.2017
* @version 2.0
*/

public class SortNameLengthComparator implements Comparator<Users> {
/**
* Класс SortNameLengthComparator.
*/
/**
* Метод compare. Сравнение длин имен в двух объектах.
* @param user1 Первый объект.
* @param user2 Второй объект.
* @return Результат сравнения.
*/
	public int compare(Users user1, Users user2) {
		int result = 0;
		int lenUser1 = user1.getName().length();
		int lenUser2 = user2.getName().length();
		if (lenUser1 > lenUser2) {
			result = 1;
		}
		if (lenUser1 < lenUser2) {
			result = -1;
		}
		return result;
	}
}