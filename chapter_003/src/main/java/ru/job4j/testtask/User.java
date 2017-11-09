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

//* Метод equals. Сравнивает текущий объект с заданным obj.
//* @param user Объект.
//* @return true, если объекты равны, а иначе - false.
	//public boolean equals(User user) {
		//boolean result = false;
		//if (user != null && this == user) {
			//result = true;
		//}
		//if (this.name == user.getName() && this.pasport == user.getPasport()) {
			//result = true;
		//}
		//return result;
	//}
//* Метод hashCode.
//* @return Хэш-код текущего объекта.
	//public int hashCode() {
		//return this.hashCode();
	//}
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