package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс ArrayDuplicateTest тестирует метод класса ArrayDuplicate.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 05.09.2017
* @version 1.0
*/

public class ArrayDuplicateTest {
/**
* Class ArrayDuplicateTest.
*/
/**
* Тест метода remove.
*/
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		// Создаем массив из строк
		String[] listString = {"melon", "copter", "melon", "jointer", "copter", "spin", "electron"};
		// Определяем результат выполнения метода
		ArrayDuplicate arrdupl = new ArrayDuplicate();
		String[] result = arrdupl.remove(listString);
		// Ожидаемое значение
		String[] expectArray = {"melon", "copter", "electron", "jointer", "spin"};
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expectArray));
	}
}