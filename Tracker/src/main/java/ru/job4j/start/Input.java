package ru.job4j.start;

/**
* Интерфейс Input.
* Определяет общий метод ask() для классов Console- и StubInput.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 22.09.2017
* @version 2.0
*/
public interface Input {
/**
* Интерфейс Input.
*/
/**
* Метод ask.
* @param question Вопрос пользователю(для класса ConsoleInput).
* @return Введенные данные с консоли или выбор меню во время теста.
*/
	String ask(String question);
}