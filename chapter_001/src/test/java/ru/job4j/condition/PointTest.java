package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс PointTest тестирует методы класса Point.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 27.08.17
* @version 1.0
*/

public class PointTest {
/**
* Метод определяет принадлежность точки к функции.
* И сравнивает результат с ожидаемым значением.
*/
	@Test
	public void whenPointOnLineThenTrue() {
		// Новый объект класса Point
		Point a = new Point(1, 1);
		// Проверяем принадлежность точки к заданной функции, при значениях a = 0, b = 1
		boolean rsl = a.is(0, 1);
		// Проверяем результат и ожидаемое значение
		assertThat(rsl, is(true));
	}
}