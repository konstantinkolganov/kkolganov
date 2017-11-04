package ru.job4j.sorting;

import java.util.Comparator;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
/**
* Класс SortUser.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.11.2017
* @version 2.0
*/

public class SortUser {
/**
* Класс SortUser.
*/
	private SortNameLengthComparator snlcomp = new SortNameLengthComparator(); /**Компаратор для сортировки User-ов по имени.*/
	private Comparator<Users> comparator = new SortNameLengthComparator()
			.thenComparing(new SortByAllFieldsComparator()); /**Компаратор для сортировки элементов по двум полям.*/
/**
* Метод sortNameLength. Сортировка элементов List<Users> по длине имени.
* @param list Список Users.
* @return Отсортированный список.
*/
	public List<Users> sortNameLength(List<Users> list) {
		List<Users> userList = list;
		userList.sort(this.snlcomp);
		return userList;
	}
/**
* Метод sortByAllFields. Сортировка элементов List<Users> по длине имени и возрасту.
* @param list Список Users.
* @return Отсортированный список.
*/
	public List<Users> sortByAllFields(List<Users> list) {
		List<Users> userList = list;
		userList.sort(this.comparator);
		return userList;
	}
/**
* Метод sort.
* Конвертация списка пользователей в отсортированное множество TreeSet.
* @param list Список пользователей ArrayList.
* @return Множество Set.
*/
	public Set<Users> sort(List<Users> list) {
		Set<Users> set = new TreeSet<Users>();
		for (Users users : list) {
			if (users != null) {
				set.add(users);
			}
		}
		return set;
	}
}