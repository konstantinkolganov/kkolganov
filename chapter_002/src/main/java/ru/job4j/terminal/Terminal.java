package ru.job4j.terminal;

/**
* Класс Terminal обеспечивает работу с плюшками и монетами.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class Terminal {
/**
* Класс Terminal.
*/
	private Buns[] buns; /**Массив хранения доступных плюшек.*/
	private Coins[] coins; /**Массив хранения монет 10, 5, 2 и 1.*/
/**
* Метод testCoins.
* Возвращает количество монет определенного номинала(для теста).
* @param den Номинал.
* @return Количество монет.
*/
	public int testCoins(int den) {
		int retAmount = 0;
		for (int i = 0; i < this.coins.length; i++) {
			if (den == this.coins[i].getDenom()) {
				retAmount = this.coins[i].getAmount();
			}
		}
		return retAmount;
	}
/**
* Метод fillBuns. Инициализация массива плюшек.
* @param buns Массив плюшек.
*/
	public void fillBuns(Buns[] buns) {
		this.buns = buns;
	}
/**
* Метод getBuns.
* @return Массив плюшек.
*/
	public Buns[] getBuns() {
		return this.buns;
	}
/**
* Метод fillCoins. Реализует возможность пополнения монет.
* @param coins Массив монет.
*/
	public void fillCoins(Coins[] coins) {
		this.coins = coins;
	}
/**
* Метод getCoins.
* @return Массив монет.
*/
	public Coins[] getCoins() {
		return this.coins;
	}
}