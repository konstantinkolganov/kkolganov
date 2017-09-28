package ru.job4j.start;

/**
* Интерфейс UserAction описывает основные действия меню(добавление, удаление, поиск и т.д.).
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 25.09.2017
* @version 2.0
*/

public interface UserAction {
/**
* Интерфейс UserAction.
*/
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return Ключ.
*/
	String key();
/**
* Метод execute.
* Исполнение действия над заявками.
* @param tracker Tracker.
* @param input Input.
*/
	void execute(Tracker tracker, Input input);
/**
* Метод info.
* Отображение информации.
* @return Info.
*/
	String info();
}