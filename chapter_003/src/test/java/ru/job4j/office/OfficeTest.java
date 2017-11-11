package ru.job4j.office;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс OfficeTest. Тест сортировки классов подразделений.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 10.11.2017
* @version 2.0
*/

public class OfficeTest {
/**
* Класс OfficeTest.
*/
/**
* Тест метода sortAscending. Сортирующий в порядке возрастания.
*/
	@Test
	public void whenCallMethodSortAscendingThenArraySortInAscendingOrder() {
		// Создать объект Office
		Office office = new Office();
		// Создать массив кодов подразделений. Коды расположены в хаотичном порядке.
		String[] array = new String[10];
		array[0] = "K1";
		array[1] = "K1\\SK1";
		array[2] = "K2";
		array[3] = "K2\\SK1\\SSK1";
		array[4] = "K1\\SK1\\SSK2";
		array[5] = "K1\\SK2";
		array[6] = "K1\\SK1\\SSK1";
		array[7] = "K2\\SK1\\SSK2";
		array[8] = "K2\\SK1";
		array[9] = "K2\\SK2";
		// Отсортировать элементы массива array в порядке возрастания с помощью метода sortAscending.
		String[] sortArray = office.sortAscending(array);
		// Создать массив, который будет копией отсортированного
		String[] copySortArray = new String[10];
		copySortArray[0] = "K1";
		copySortArray[1] = "K1\\SK1";
		copySortArray[2] = "K1\\SK1\\SSK1";
		copySortArray[3] = "K1\\SK1\\SSK2";
		copySortArray[4] = "K1\\SK2";
		copySortArray[5] = "K2";
		copySortArray[6] = "K2\\SK1";
		copySortArray[7] = "K2\\SK1\\SSK1";
		copySortArray[8] = "K2\\SK1\\SSK2";
		copySortArray[9] = "K2\\SK2";
		// Сравнить результат с ожидаемым значением
		assertThat(sortArray, is(copySortArray));
	}
/**
* Тест метода sortDesrcrease. Сортирует массив в порядке уюывания.
*/
	@Test
	public void whenCallMethodSortDescreaseThenArraySortInDescendingOrder() {
		// Создать объект Office
		Office office = new Office();
		// Создать массив кодов подразделений. Коды расположены в хаотичном порядке.
		String[] array = new String[10];
		array[0] = "K1";
		array[1] = "K1\\SK1";
		array[2] = "K2";
		array[3] = "K2\\SK1\\SSK1";
		array[4] = "K1\\SK1\\SSK2";
		array[5] = "K1\\SK2";
		array[6] = "K1\\SK1\\SSK1";
		array[7] = "K2\\SK1\\SSK2";
		array[8] = "K2\\SK1";
		array[9] = "K2\\SK2";
		// Отсортировать элементы массива array в порядке убывания с помощью метода sortAscending.
		String[] sortArray = office.sortDescrease(array);
		// Создать массив, который будет копией отсортированного
		String[] copySortArray = new String[10];
		copySortArray[0] = "K2";
		copySortArray[1] = "K2\\SK2";
		copySortArray[2] = "K2\\SK1";
		copySortArray[3] = "K2\\SK1\\SSK2";
		copySortArray[4] = "K2\\SK1\\SSK1";
		copySortArray[5] = "K1";
		copySortArray[6] = "K1\\SK2";
		copySortArray[7] = "K1\\SK1";
		copySortArray[8] = "K1\\SK1\\SSK2";
		copySortArray[9] = "K1\\SK1\\SSK1";
		// Сравнить результат с ожидаемым значением
		assertThat(sortArray, is(copySortArray));
	}
}