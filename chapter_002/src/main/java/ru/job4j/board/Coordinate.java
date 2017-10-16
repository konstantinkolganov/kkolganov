package ru.job4j.board;

/**
* Класс Coordinate определяет положение ячейки(клетки) в плоскости шахматной доски.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.10.2017
* @version 2.0
*/

public class Coordinate {
/**
* Класс Position.
*/
	private int x; /**Горизонталь.*/
	private int y; /**Вертикаль.*/
	private Cell cell; /**Ячейка.*/
/**
* Конструктор класса.
* @param x Положение по горизонтали.
* @param y Положение по вертикали.
* @param cell Ячейка доски.
*/
	public Coordinate(int y, int x, Cell cell) {
		this.y = y;
		this.x = x;
		this.cell = cell;
	}
/**
* Метод getX.
* Получение x.
* @return x.
*/
	public int getX() {
		return this.x;
	}
/**
* Метод getY.
* Получение y.
* @return y.
*/
	public int getY() {
		return this.y;
	}
/**
* Метод getCell. Возвращает ячейку.
* @return ячейка.
*/
	public Cell getCell() {
		return this.cell;
	}
}