package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс PaintTest тестирует метод класса Paint.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 01.09.2017
* @version 1.0
*/

public class PaintTest {
/**
* Тест метода piramid. Высота пирамиды - 2.
*/
	@Test
	public void whenPiramidWithWeightTwoThenStringWithTwoRows() {
		// Новый объект класса Paint
		Paint paint = new Paint();
		// Отрисовка пирамиды высотой 2
		String result = paint.piramid(2);
		// Ожидаемое значение
		String expected = String.format(" ^ \r\n^^^\r\n", System.getProperty("line.separator"));
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
/**
* Тест метода piramid. Высота пирамиды - 3.
*/
	@Test
	public void whenPiramidWithWeightThreeThenStringWithThreeRows() {
		// Новый объект класса Paint
		Paint paint = new Paint();
		// Отрисовка пирамиды высотой 2
		String result = paint.piramid(3);
		// Ожидаемое значение
		final String line = System.getProperty("line.separator");
		String expected = String.format("  ^  \r\n ^^^ \r\n^^^^^\r\n", System.getProperty("line.separator"));
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
}