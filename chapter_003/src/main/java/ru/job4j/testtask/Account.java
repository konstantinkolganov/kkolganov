package ru.job4j.testtask;

/**
* Класс Account.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.11.2017
* @version 2.0
*/

public class Account {
/**
* Класс Account.
*/
	private double value; /**Количество денег.*/
	private Requisites requisites; /**Реквизиты.*/
/**
* Конструктор класса.
* @param value Деньги.
*/
	public Account(double value) {
		this.value = value;
		this.requisites = new Requisites();
	}
/**
* Метод setValue.
* Установка нового знаения переменной value.
* @param value Количество денег.
*/
	public void setValue(double value) {
		this.value = value;
	}
/**
* Метод setValue.
* Возвращает текущее количество денег на аккаунте.
* @return value.
*/
	public double getValue() {
		return this.value;
	}
/**
* Метод getRequisites.
* Возвращает реквизиты вызывающего аккаунта.
* @return Реквизиты.
*/
	public Requisites getRequisites() {
		return this.requisites;
	}
}