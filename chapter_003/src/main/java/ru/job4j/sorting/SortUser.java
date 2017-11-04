package ru.job4j.sorting;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
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
/**
* Метод main.
* @param args args.
*/
	public static void main(String[] args) {
		// Создать новый список пользователей ArrayList
		List<Users> list = new ArrayList<Users>();
		list.add(new Users("Zheka", 28));
		list.add(new Users("Petr", 33));
		list.add(new Users("Masha", 22));
		list.add(new Users("Konstantin", 25));
		list.add(new Users("Slava", 60));
		// Вывести List на экран
		System.out.println("Added entries: ");
		for (Users user : list) {
			System.out.println(String.format("%s - %s;", user.getName(), user.getAge()));
		}
		System.out.println();
		// Создать объект SortUser
		SortUser sortUs = new SortUser();
		// Конвертируем List в отсортированное множество TreeSet
		Set<Users> set = sortUs.sort(list);
		// Вывести Set на экран
		System.out.println("Modified List: ");
		for (Users user : set) {
			System.out.println(String.format("%s - %s;", user.getName(), user.getAge()));
		}
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