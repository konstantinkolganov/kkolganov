package ru.job4j.terminal;

/**
* Класс UnacceptableBillException.
* Генерирует исключение, если не хватает монет для выдачи сдачи.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class UnacceptableBillException extends Exception {
/**
* Класс UnacceptableBillException.
*/
/**
* Конструктор класса.
* @param ube Сообщение.
*/
	public UnacceptableBillException(String ube) {
		super(ube);
	}
}