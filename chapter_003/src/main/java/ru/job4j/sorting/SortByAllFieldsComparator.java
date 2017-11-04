package ru.job4j.sorting;

import java.util.Comparator;
/**
* Класс SortByAllFieldsComparator. Сортировка элементов по возрасту.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 04.11.2017
* @version 2.0
*/

public class SortByAllFieldsComparator implements Comparator<Users> {
/**
* Класс SortByAllFieldsComparator.
*/
/**
* Метод compare. Сравнение элементов по возрасту.
* @param user1 Первый объект.
* @param user2 Второй объект.
* @return Результат сравнения.
*/
	public int compare(Users user1, Users user2) {
		int result = 0;
		if (user1.getAge() > user2.getAge()) {
			result = 1;
		}
		if (user1.getAge() < user2.getAge()) {
			result = -1;
		}
		return result;
	}
}