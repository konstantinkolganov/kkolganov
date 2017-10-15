package ru.job4j.terminal;

/**
* Класс InsufficientFundsException.
* Генерирует исключение, если внесенной суммы недостаточно для оплаты.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class InsufficientFundsException extends Exception {
/**
* Класс InsufficientFundsException.
*/
/**
* Конструктор класса.
* @param ife Сообщение об ошибке.
*/
	public InsufficientFundsException(String ife) {
		super(ife);
	}
}