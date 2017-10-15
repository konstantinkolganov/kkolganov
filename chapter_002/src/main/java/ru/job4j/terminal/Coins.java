package ru.job4j.terminal;

/**
* Класс Coins. Монеты.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class Coins {
/**
* Класс Coins.
*/
	private int denom; /**Номинал.*/
	private int amount; /**Количество монет.*/
/**
* Конструктор класса.
* @param denom Номинал.
* @param amount Количество.
*/
	public Coins(int denom, int amount) {
		this.denom = denom;
		this.amount = amount;
	}
/**
* Метод setAmount. Запись изменения количества монет.
* @param amount amount.
*/
	public void setAmount(int amount) {
		this.amount = amount;
	}
/**
* Метод getAmount. Получение текущего количества монет.
* @return int int.
*/
	public int getAmount() {
		return this.amount;
	}
/**
* Метод getDenom. Получение номинала.
* @return int int.
*/
	public int getDenom() {
		return this.denom;
	}
}