package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс TurnTest проверяет методы класса Turn.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.09.2017
* @version 1.0
*/

public class TurnTest {
/**
* Тест метода back, проверяющий переворот массива с четным числом элементов.
*/
	@Test
	public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
		// Новый объект класса Turn
		Turn turn = new Turn();
		// Создаем новый массив с четным числом элементов
		int[] massive = {2, 6, 1, 4};
		// Меняем последовательность значений на обратную
		int[] resultArray = turn.back(massive);
		// Ожидаемое значение
		int[] expectArray = {4, 1, 6, 2};
		// Сравниваем результат с ожидаемым значением
		assertThat(resultArray, is(expectArray));
	}
/**
* Тест метода back, проверяющий переворот массива с нечетным числом элементов.
*/
	@Test
	public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
		// Новый объект класса Turn
		Turn turn = new Turn();
		// Создаем новый массив с четным числом элементов
		int[] massive = {1, 2, 3, 4, 5};
		// Меняем последовательность значений на обратную
		int[] resultArray = turn.back(massive);
		// Ожидаемое значение
		int[] expectArray = {5, 4, 3, 2, 1};
		// Сравниваем результат с ожидаемым значением
		assertThat(resultArray, is(expectArray));
	}
}