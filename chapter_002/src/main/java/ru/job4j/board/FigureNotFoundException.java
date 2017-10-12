package ru.job4j.board;

/**
* Класс FigureNotFoundException позволяет генерировать исключение если в ячейке не найдена фигура.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.10.2017
* @version 2.0
*/

public class FigureNotFoundException extends Exception {
/**
* Класс FigureNotFoundException.
*/
/**
* Конструктор класса.
* @param fnfe Сообщение об ошибке.
*/
	public FigureNotFoundException(String fnfe) {
		super(fnfe);
	}
}