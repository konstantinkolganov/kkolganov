package ru.job4j.generic;

import java.util.Random;

/**
* Класс Role.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 14.11.2017
* @version 2.0
*/

public class Role extends Base {
/**
* Класс Role.
*/
	private String name; /**Name.*/
	private String id; /**Номер id.*/
	private final Random rn = new Random(); /**Рандом.*/
/**
* Конструктор класса.
* @param id Номер пользователя.
* @param name Name.
*/
	public Role(String id, String name) {
		this.id = id;
		this.name = name;
	}
/**
* Метод getName. Возвращает имя.
* @return Name.
*/
	public String getName() {
		return this.name;
	}
/**
* Метод getId. Возвращает id.
* @return Номер id.
*/
	public String getId() {
		return this.id;
	}
/**
* Метод setId. Устанавливает новое знаение id.
* @param id Номер.
*/
	public void setId(String id) {
		this.id = id;
	}
/**
* Метод equals. Сравнивает объекты User по имени.
* @param o Object.
* @return Логическое true, если имена объектов равны.
*/
	public boolean equals(Object o) {
		boolean result;
		Role role = (Role) o;
		if (role == null) {
			result = false;
		} else if (this.getClass() != role.getClass()) {
			result = false;
		} else if (this.id != role.id) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
/**
* Метод hashCode().
* @return Хэш-код объекта.
*/
	public int hashCode() {
		return rn.nextInt(2000000);
	}
}