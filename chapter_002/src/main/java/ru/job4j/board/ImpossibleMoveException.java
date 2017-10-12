package ru.job4j.board;

/**
* Класс ImpossibleMoveException.
* Позволяет генерировать исключение, если фигура не может быть перемещена в заданную ячейку.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.10.2017
* @version 2.0
*/

public class ImpossibleMoveException extends Exception {
/**
* Класс ImpossibleMoveException.
*/
/**
* Конструктор класса.
* @param ime Сообщение об ошибке.
*/
	public ImpossibleMoveException(String ime) {
		super(ime);
	}
}