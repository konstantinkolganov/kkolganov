package ru.job4j.start;

/**
* Класс BaseAction предоставляет частичную реализацию интерфейса UserAction.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.10.2017
* @version 2.0
*/

public abstract class BaseAction implements UserAction {
/**
* Класс BaseAction.
*/
	private String name; /**Название операции.*/
	private int key; /**Номер операции.*/
/**
* Конструктор класса.
* @param name Название операции.
* @param key Номер операции.
*/
	public BaseAction(String name, int key) {
		this.name = name;
		this.key = key;
	}
/**
* Абстрактный метод execute.
* В подклассе реализует функции, соответствующие данному разделу меню.
* @param tracker Tracker.
* @param input Input.
*/
	public abstract void execute(Tracker tracker, Input input);
/**
* Метод key.
* @return Ключ операции.
*/
	public int key() {
		return this.key;
	}
/**
* Метод info.
* @return Описание действия.
*/
	public String info() {
		return String.format("%s. %s", this.key, this.name);
	}
}