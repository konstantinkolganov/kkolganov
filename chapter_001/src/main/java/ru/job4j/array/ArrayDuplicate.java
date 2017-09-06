package ru.job4j.array;

import java.util.Arrays;
/**
* Класс ArrayDublicate убирает дубликаты строк из массива.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 05.09.2017
* @version 1.0
*/
public class ArrayDuplicate {
/**
* Класс ArrayDuplicate.
* Один метод remove.
*/
/**
* Метод remove.
* Внешний цикл хватает элемент массива, внутренний перебирает следующие за ним элементы
* и сравнивает их значения со значением проверочного.
* @param array Массив значений типа String.
* @return Копия массива без дубликатов.
*/
	public String[] remove(String[] array) {
		// Переменная-счетчик дублированных значений
		int num = 0;
		// Константа размера массива
		int size = array.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] == array[j]) {
					String tmp = null; // Для промежуточных значений
					tmp = array[j];
					array[j] = array[size - 1 - num];
					array[size - 1 - num] = tmp;
					num++;
					break;
				}
			}
		}
		return Arrays.copyOf(array, (size - num));
	}
}