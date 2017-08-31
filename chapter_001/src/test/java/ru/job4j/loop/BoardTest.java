package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс BoardTest тестирует класс Board.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 31.08.2017
* @version 1.0
*/

public class BoardTest {
/**
* Метод тестирует метод класса Board.
* При условии, что ширина доски - 3, высота - 3.
*/
	@Test
	public void whenPaintBoardWithThreeWidthAndThreeWeightThenStringWithThreeColsAndThreeRows() {
		// Новый объект класса Board
		Board board = new Board();
		// Отрисовываем шахматную доску 3x3
		String result = board.paint(3, 3);
		final String line = System.getProperty("line.separator");
		// Сравниваем результат с ожидаемым значением
		String expected = String.format("x x%s x %sx x%s", line, line, line);
		assertThat(result, is(expected));
	}
/**
* Метод тестирует метод класса Board.
* При условии, что ширина доски - 5, высота - 4.
*/
	@Test
	public void whenPaintBoardWithFiveWidthAndFourWeightThenStringWithFiveColsAndFourRows() {
		// Новый объект класса Board
		Board board = new Board();
		// Отрисовываем шахматную доску 5x4
		String result = board.paint(5, 4);
		final String line = System.getProperty("line.separator");
		// Сравниваем результат с ожидаемым значением
		String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
		assertThat(result, is(expected));
	}
}