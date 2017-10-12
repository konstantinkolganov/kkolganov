package ru.job4j.board;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс StartTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.10.2017
* @version 2.0
*/

public class StartTest {
/**
* Тест метод.
* Если в текущей ячейке стоит слон, то метод move вернет значение true.
*/
	@Test
	public void whenInCurrentCellIsElephantThenMethodMoveReturnTrue() {
		// Создаем объект класса Board
		Board board = new Board();
		// Создаем шахматную доску
		board.createBoard();
		// Создаем массив фигур и расставим их по клеткам шахматной доски
		board.createFigure();
		// Координаты текущей ячейки source
		// и целевой dist
		String source = "c-1";
		String dist = "g-5";
		// Уберем пешку "d-2" на пути слона
		board.translate("d-2").setFigure(null);
		// Результат
		boolean result = false;
		try {
			result = board.move(board.translate(source), board.translate(dist));
		} catch (ImpossibleMoveException ime) {
			System.out.println("Moving is impossible. Select another cell.");
		} catch (FigureNotFoundException fnfe) {
			System.out.println("Figure not found!");
		} catch (OccupiedWayException owe) {
			System.out.println("On the way there is a figure!");
		}
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(true));
	}
/**
* Тест метод.
* Если слон пройдет из поля c-1 в поле g-5, то получим массив из четырех ячеек.
*/
	@Test
	public void whenElephantGotoThreeCellDiagonThenReturnDistance() {
		// Создаем объект класса Board
		Board board = new Board();
		// Создаем шахматную доску
		board.createBoard();
		// Создаем массив фигур и расставим их по клеткам
		board.createFigure();
		// Координаты текущей ячейки source
		// и целевой dist
		String source = "c-1";
		String dist = "g-5";
		// Сохраним Слона!
		Figure figure = board.translate(source).getFigure();
		Cell[] cell = null;
		try {
			cell = figure.way(board.translate(dist));
		} catch (ImpossibleMoveException ime) {
			System.out.println("Moving is impossible. Select another cell.");
		}
		// Сравниваем результат с ожидаемым значением
		assertThat(cell.length, is(4));
	}
/**
* Тест метод.
* Если выполняются все условия перемещения, то слон из поля "c-1" окажется в "d-5".
*/
	@Test
	public void whenElephantGotoFourCellDiagonThenDistCellGetElephant() {
		// Создаем объект класса Board
		Board board = new Board();
		// Создаем шахматную доску
		board.createBoard();
		// Создаем массив фигур и расставим их по клеткам
		board.createFigure();
		// Координаты текущей ячейки source
		// и целевой dist
		String source = "c-1";
		String dist = "g-5";
		// Уберем пешку "d-2" на пути слона
		board.translate("d-2").setFigure(null);
		// Сохраним Слона!
		Figure figure = board.translate(source).getFigure();
		// Новый объект класса Start
		Start start = new Start(board);
		// Двигаем фигуру из source в dist
		start.init(source, dist);
		// Сравниваем результат с ожидаемым значением
		assertThat(board.translate(dist).getFigure(), is(figure));
	}
}