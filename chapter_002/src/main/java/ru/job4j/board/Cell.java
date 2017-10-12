package ru.job4j.board;

/**
* Класс Cell Ячейка шахматной доски.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.10.2017
* @version 2.0
*/

public class Cell {
/**
* Класс Cell.
*/
	private String color; /**Цвет поля.*/
	private Coordinate coordinate; /**Координаты ячейки.*/
	private Figure figure; /**Перемення для хранения фигуры.*/
/**
* Конструктор класса.
* @param coordinate Координаты ячейки в плоскости доски.
* @param color Цвет ячейки.
*/
	public Cell(Coordinate coordinate, String color) {
		this.coordinate = coordinate;
		this.color = color;
	}
/**
* Метод getCoordinate.
* Получение содержимого coordinate.
* @return coordinate Coordinate.
*/
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
/**
* Метод setFigure.
* Добавление в ячейку фигуры.
* @param figure Figure.
*/
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
/**
* Метод getFigure.
* Получение содержимого figure.
* @return figure Figure.
*/
	public Figure getFigure() {
		return this.figure;
	}
}