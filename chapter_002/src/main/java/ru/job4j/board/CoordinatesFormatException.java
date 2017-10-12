package ru.job4j.board;

/**
* Класс CoordinatesFormatException.
* Выбрасывает исключение, если адрес ячейки шахматной доски указан неверно.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.10.2017
* @version 2.0
*/

public class CoordinatesFormatException extends Exception {
/**
* Класс CoordinatesFormatException.
*/
/**
* Конструктор класса.
* @param cfe Сообщение об ошибке.
*/
	public CoordinatesFormatException(String cfe) {
		super(cfe);
	}
}