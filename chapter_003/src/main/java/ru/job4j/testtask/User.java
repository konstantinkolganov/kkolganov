package ru.job4j.testtask;

/**
* Класс User.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.11.2017
* @version 2.0
*/

public class User {
/**
* Класс User.
*/
	private String name; /**Имя пользователя.*/
	private Pasport pasport; /**Паспорт.*/
/**
* Конструктор класса.
* @param name Имя пользователя.
* @param pasport Паспортные данные пользователя.
*/
	public User(String name, Pasport pasport) {
		this.name = name;
		this.pasport = pasport;
	}
/**
* Метод equals. Сравнивает текущий объект с заданным obj.
* @param obj Объект.
* @return true, если объекты равны, а иначе - false.
*/
	public boolean equals(Object obj) {
		boolean result = true;
		if (this == obj) {
			result = true;
		}
		if (obj == null) {
			result = false;
		}
		if (this.getClass() != obj.getClass()) {
			result = false;
		}
		User other = (User) obj;
		if (this.name != other.name) {
			result = false;
		}
		if (this.pasport != other.pasport) {
			result = false;
		}
		return result;
	}
/**
* Метод hashCode.
* @return Хэш-код текущего объекта.
*/
	public int hashCode() {
		final int prime = 30;
		int result = 1;
		result = prime * result + this.name.codePointAt(0);
		result = prime * result + this.pasport.getUnicodeName();
		return result;
	}
/**
* Метод getName.
* @return Имя пользователя.
*/
	public String getName() {
		return this.name;
	}
/**
* Метод getPasport.
* @return Паспортные данные пользователя.
*/
	public Pasport getPasport() {
		return this.pasport;
	}
}