package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс BubbleSortTest проверяет методы класс BubbleSort.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.09.2017
* @version 1.0
*/
public class BubbleSortTest {
/**
* Тест метода sort, который принимает массив из 10 элементов.
*/
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		// Новый объект класса BubbleSort
		BubbleSort arraySort = new BubbleSort();
		// Новый целочисленный массив из 10 элементов
		int[] massive = {8, 1, 3, 0, 9, 5, 2, 4, 7, 6};
		// Сортируем объявленный массив
		int[] resultArray = arraySort.sort(massive);
		// Ожидаемое значение
		int[] expectArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		// Сравниваем результат с ожидаемым значением
		assertThat(resultArray, is(expectArray));
	}
}