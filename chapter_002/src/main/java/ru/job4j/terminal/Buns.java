package ru.job4j.terminal;

/**
* Класс Buns. Плюшки.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class Buns {
/**
* Class Buns.
*/
	private String name; /**Название.*/
	private int price; /**Цена.*/
	private int number; /**Количество.*/
/**
* Конструктор класса.
* @param name Название.
* @param price Цена.
* @param number Количество плюшек в автомате.
*/
	public Buns(String name, int price, int number) {
		this.name = name;
		this.price = price;
		this.number = number;
	}
/**
* Метод setNumber.
* @param number Количество.
*/
	public void setNumber(int number) {
		this.number = number;
	}
/**
* Метод getNumber.
* @return Возвращает текущее число плюшек.
*/
	public int getNumber() {
		return this.number;
	}
/**
* Метод getPrice.
* @return Возвращает цену.
*/
	public int getPrice() {
		return this.price;
	}
/**
* Метод getName.
* @return Возвращает название.
*/
	public String getName() {
		return this.name;
	}
}