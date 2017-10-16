package ru.job4j.board;

/**
* Класс Figure определяет фигуры шахматной доски.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.10.2017
* @version 2.0
*/

public abstract class Figure {
/**
* Абстрактный класс Figure.
*/
	private String name; /**Название фигуры.*/
	private String color; /**Цвет фигуры.*/
	private Cell position; /**Ячейка доски.*/
/**
* Конструктор класса.
* @param name Наименование фигуры.
* @param color Цвет фигуры.
* @param position Ячейка, где будет храниться фигура.
*/
	public Figure(String name, String color, Cell position) {
		this.name = name;
		this.color = color;
		this.position = position;
	}
/**
* Метод way.
* Определяет возможность и путь прохождения фигуры к назначенной ячейке.
* @param dist Ячейка назначения, куда следует пойти.
* @return Массив ячеек, через которые нужно пройти для достижения заданной ячейки.
* @throws ImpossibleMoveException Исключение в случае невозможности прохода фигуры.
*/
	abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
/**
* Метод clone. Задает новое положение фигуры.
* @param dist Новое месторасположение фигуры.
*/
	public void clone(Cell dist) {
		this.position = dist;
	}
/**
* Метод setPosition.
* @param position Новое значение position.
*/
	public void setPosition(Cell position) {
		this.position = position;
	}
/**
* Метод getPosition.
* @return Возвращает ячейку, где стоит данная фигура.
*/
	public Cell getPosition() {
		return this.position;
	}
}