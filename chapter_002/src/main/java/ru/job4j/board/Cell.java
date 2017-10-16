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
/**
* Конструктор класса.
* @param color Цвет ячейки.
*/
	public Cell(String color) {
		this.color = color;
	}
}