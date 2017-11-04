package ru.job4j.sorting;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс SortUserTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 04.11.2017
* @version 2.0
*/

public class SortUserTest {
/**
* Класс SortUserTest.
*/
/**
* Тест класса SortUser.
*/
	@Test
	public void whenListSortedInMethodSortThenGetTreeSetUsers() {
		// Создать новый список пользователей ArrayList
		List<Users> list = new ArrayList<Users>();
		list.add(new Users("Zheka", 28));
		list.add(new Users("Petr", 33));
		list.add(new Users("Masha", 22));
		list.add(new Users("Konstantin", 25));
		list.add(new Users("Slava", 60));
		// Создать объект SortUser
		SortUser sortUs = new SortUser();
		// Конвертируем List в отсортированное множество TreeSet
		Set<Users> set = sortUs.sort(list);
		// Получим первый элемент множества Set с помощью массива
		Users[] array = set.toArray(new Users[1]);
		// Сравним результат с ожидаемым значением
		assertThat(array[0].getAge(), is(list.get(2).getAge()));
	}
/**
* Если сортировка пользователей происходит по имени.
*/
	@Test
	public void whenSortedByLengthNameThenFirstElementListUserWithTheShortestName() {
		// Новый список пользователей ArrayList
		List<Users> list = new ArrayList<Users>();
		list.add(new Users("Zheka", 28));
		list.add(new Users("Petr", 33));
		list.add(new Users("Masha", 22));
		list.add(new Users("Konstantin", 25));
		list.add(new Users("Slava", 60));
		// Сохраним юзер с именем "Petr"
		Users user = list.get(1);
		// Новый объект SortUser
		SortUser sortUs = new SortUser();
		// Сортируем список list по именам в порядке возрастания
		List<Users> list2 = sortUs.sortNameLength(list);
		// Сравниваем результат с ожидаемым значением
		assertThat(list2.get(0), is(user));
	}
/**
* Если имена двух пользователей совпадают, то сортировка идет по имени.
*/
	@Test
	public void whenNamesUsersIsConcidenceThenSortingTakesPlaceByAge() {
		// Новый список пользователей ArrayList
		List<Users> list = new ArrayList<Users>();
		list.add(new Users("Konstantin", 25));
		list.add(new Users("Mikhail", 28));
		list.add(new Users("Slava", 60));
		list.add(new Users("Nikolay", 22));
		list.add(new Users("Zheka", 33));
		// Сохраним юзер с именем "Petr"
		Users user = list.get(4);
		// Новый объект SortUser
		SortUser sortUs = new SortUser();
		// Сортируем список list по имени и возрасту
		List<Users> list2 = sortUs.sortByAllFields(list);
		// Сравниваем результат с ожидаемым значением
		assertThat(list2.get(0), is(user));
	}
}