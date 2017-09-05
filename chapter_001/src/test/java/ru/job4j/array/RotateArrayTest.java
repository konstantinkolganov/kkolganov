package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс RotateArrayTest тестирует методы класса RotateArrayTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 05.09.2017
* @version 1.0
*/

public class RotateArrayTest {
/**
* Class RotateArrayTest.
*/
/**
* Тест метода rotate при условии, что он принимает двухмерный массив.
*/
	@Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
		// Создаем двухмерный массив 2х2 и инициализируем его
		int[][] array = new int[2][2];
		array[0][0] = 0;
		array[0][1] = 1;
		array[1][0] = 0;
		array[1][1] = 2;
		// Новый объект класса RotateArray
		RotateArray rotArr = new RotateArray();
		// Результат выполнения
		int[][] editedArray = rotArr.rotate(array);
		// Ожидаемое значение
		int[][] expectArray = new int[2][2];
		expectArray[0][0] = 0;
		expectArray[0][1] = 0;
		expectArray[1][0] = 2;
		expectArray[1][1] = 1;
		// Сравниваем результат с ожидаемым значением
		assertThat(editedArray, is(expectArray));
	}
/**
* Тест метода rotate при условии, что он принимает трехмерный массив.
*/
	@Test
	public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
		// Создаем трехмерный массив 3х3 и инициализируем его
		int[][] array = new int[3][3];
		array[0][0] = 0;
		array[0][1] = 1;
		array[0][2] = 2;
		array[1][0] = 0;
		array[1][1] = 2;
		array[1][2] = 4;
		array[2][0] = 0;
		array[2][1] = 3;
		array[2][2] = 6;
		// Новый объект класса RotateArray
		RotateArray rotArr = new RotateArray();
		// Результат выполнения
		int[][] editedArray = rotArr.rotate(array);
		// Ожидаемое значение
		int[][] expectArray = new int[3][3];
		expectArray[0][0] = 0;
		expectArray[0][1] = 0;
		expectArray[0][2] = 0;
		expectArray[1][0] = 3;
		expectArray[1][1] = 2;
		expectArray[1][2] = 1;
		expectArray[2][0] = 6;
		expectArray[2][1] = 4;
		expectArray[2][2] = 2;
		// Сравниваем результат с ожидаемым значением
		assertThat(editedArray, is(expectArray));
	}
}