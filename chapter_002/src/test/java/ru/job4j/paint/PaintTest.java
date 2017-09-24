package ru.job4j.paint;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс PaintTest тестирует методы pic() классов Triangle и Square.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 24.09.2017
* @version 2.0
*/

public class PaintTest {
/**
* Тест метода pic() для класса Triangle.
*/
	@Test
	public void whenTriangleHeightFiveThenStringWithFiveRows() {
		// Создаем объект класса Paint
		Paint paint = new Paint();
		// Создаем поток вывода
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// Запишем треугольник в поток вывода out
		System.setOut(new PrintStream(out));
		paint.draw(new Triangle());
		// Вернем треугольник в виде строки
		String result = out.toString();
		// Ожидаемое значение
		String expected = String.format("\r\n*    \r\n**   \r\n***  \r\n**** \r\n*****\r\n", System.getProperty("line.separator"));
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
/**
* Тест метода pic() для класса Square.
*/
	@Test
	public void whenSquareHeightFourThenStringWithFourRowsAndFourCols() {
		// Создаем объект класса Paint
		Paint paint = new Paint();
		// Создаем поток вывода
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// Запишем треугольник в поток вывода out
		System.setOut(new PrintStream(out));
		paint.draw(new Square());
		// Вернем треугольник в виде строки
		String result = out.toString();
		// Ожидаемое значение
		String expected = String.format("\r\n****\r\n****\r\n****\r\n****\r\n", System.getProperty("line.separator"));
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
}