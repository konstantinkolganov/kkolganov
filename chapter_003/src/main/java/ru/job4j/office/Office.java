package ru.job4j.office;

import java.util.Collection;
import java.util.Arrays;
import java.util.TreeSet;

/**
* Класс Office. Справочник подразделений.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 10.11.2017
* @version
*/

public class Office {
/**
* Класс Office.
*/
/**
* Метод sortAscending. Сортировка кодов подразделений в порядке возрастания.
* @param codes Строковый массив с кодами подразделений.
* @return Отсортированное маножество TreeSet..
*/
	public TreeSet<String> sortAscending(String[] codes) {
		Collection<String> coll = Arrays.asList(codes);
		TreeSet<String> tree = new TreeSet<>(coll);
		return tree;
	}
/**
* Метод sortDescrease. Сортировка кодов подразделений в порядке убывания.
* Сортирует при помощи компаратора OfficeComparator.
* @param codes Строковый массив с кодами подразделений.
* @return Отсортированное множество..
*/
	public TreeSet<String> sortDescrease(String[] codes) {
		TreeSet<String> tree = new TreeSet<>(new OfficeComparator());
		for (int i = 0; i < codes.length; i++) {
			tree.add(codes[i]);
		}
		return tree;
	}
}