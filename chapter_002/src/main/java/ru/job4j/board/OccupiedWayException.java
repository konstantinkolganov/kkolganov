package ru.job4j.board;

/**
* Класс OccupiedWayException.
* Позволяет генерировать исключение, если на пути стоит другая фигура.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.10.2017
* @version 2.0
*/

public class OccupiedWayException extends Exception {
/**
* Класс OccupiedWayException.
*/
/**
* Конструктор класса.
* @param owe Сообщение об ошибке.
*/
	public OccupiedWayException(String owe) {
		super(owe);
	}
}