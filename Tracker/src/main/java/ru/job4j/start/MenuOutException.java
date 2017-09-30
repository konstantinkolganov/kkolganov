package ru.job4j.start;

/**
* Класс MenuOutException.
* Генерирует исключения в случаях неверного ввода ключа меню.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 29.09.2017
* @version 2.0
*/
public class MenuOutException extends RuntimeException {
/**
* Класс MenuOutException.
*/
/**
* Конструктор класса.
* @param msg Сообщение об ошибке.
*/
	public MenuOutException(String msg) {
		super(msg);
	}
}