package ru.job4j.board;

/**
* Класс Start.
* Точка входа в программу.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.10.2017
* @version 2.0
*/

public class Start {
/**
* Класс Start.
*/
	private Board board;
/**
* Конструктор класса.
* @param board Board.
*/
	public Start(Board board) {
		this.board = board;
	}
/**
* Метод init.
* @param from Адрес текущей ячейки.
* @param were Адрес целевой ячейки.
*/
	public void init(String from, String were) {
		try {
			Cell source = this.board.translate(from);
			Cell dist = this.board.translate(were);
			boolean check = this.board.move(source, dist);
			if (check) {
				Figure figure = this.board.findFig(source);
				figure.clone(dist);
			}
		} catch (ImpossibleMoveException ime) {
			System.out.println("Moving is impossible. Select another cell.");
		} catch (FigureNotFoundException fnfe) {
			System.out.println("Figure not found!");
		} catch (OccupiedWayException owe) {
			System.out.println("On the way there is a figure!");
		}
	}
}