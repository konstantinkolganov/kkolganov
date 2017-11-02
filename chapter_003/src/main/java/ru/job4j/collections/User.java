package ru.job4j.collections;

/**
* Класс User. Пользователь.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.11.2017
* @version 2.0
*/

public class User {
/**
* Класс User.
*/
	private String name; /**Name.*/
	private String city; /**Город.*/
	private int id; /**Номер id.*/
/**
* Конструктор класса.
* @param name Name.
* @param city Город.
* @param id Номер.
*/
	public User(String name, String city, int id) {
		this.name = name;
		this.city = city;
		this.id = id;
	}
/**
* Метод getId. Возвращает Id.
* @return Номер id.
*/
	public int getId() {
		return this.id;
	}
/**
* Метод getName. Возвращает name.
* @return Name.
*/
	public String getName() {
		return this.name;
	}
}