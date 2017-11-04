package ru.job4j.sorting;

/**
* Метод Users. Пользователь. Реализует интерфейс Comparable.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.11.2017
* @version 2.0
*/

public class Users implements Comparable<Users> {
/**
* Класс Users.
*/
	private String name; /**Name.*/
	private int age; /**Возраст.*/
/**
* Конструктор класса.
* @param name Name.
* @param age Возраст.
*/
	public Users(String name, int age) {
		this.name = name;
		this.age = age;
	}
/**
* Метод getName. Возвращает имя.
* @return Name.
*/
	public String getName() {
		return this.name;
	}
/**
* Метод getAge. Возвращает возраст.
* @return Возраст.
*/
	public int getAge() {
		return this.age;
	}
/**
* Метод compareTo.
* @param user Объект Users.
* @return Числовой результат сравнения возрастов юзеров.
*/
	public int compareTo(Users user) {
		int result = 0;
		if (this.age > user.getAge()) {
			result = 1;
		}
		if (this.age < user.getAge()) {
			result = -1;
		}
		return result;
	}
}