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
/**
* Конструктор класса.
* @param x Положение ячейки по горизонтали.
* @param y Положение ячейки по вертикали.
*/
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
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
}