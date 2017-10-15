package ru.job4j.terminal;

/**
* Класс Terminal реализует логику работы автомата.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class Terminal {
/**
* Класс Terminal.
*/
	private Buns[] buns = new Buns[3]; /**Массив хранения доступных плюшек.*/
	private Coins[] coins; /**Массив хранения монет 10, 5, 2 и 1.*/
/**
* Метод fillBuns. Инициализация массива плюшек.
*/
	public void fillBuns() {
		buns[0] = new Buns("S makom", 12, 15);
		buns[1] = new Buns("S kremom", 21, 15);
		buns[2] = new Buns("Bez nachinki", 8, 15);
	}
/**
* Метод fillCoins. Реализует возможность пополнения монет.
*/
	public void fillCoins() {
		this.coins = null;
		Coins[] arrCoins = new Coins[4];
		arrCoins[0] = new Coins(10, 10);
		arrCoins[1] = new Coins(5, 20);
		arrCoins[2] = new Coins(2, 50);
		arrCoins[3] = new Coins(1, 100);
		this.coins = arrCoins;
	}
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
* Метод processApp.
* Проверяет возможность приобрести указанное количество плюшек
* за внесенную сумму, и возможность выдать сдачу.
* @param name Название плюшки.
* @param number Количество плюшек.
* @param note Внесенная сумма.
* @return Если все OK, то true.
*/
	public boolean processApp(String name, int number, int note) {
		boolean check = false;
		int[] mass = null;
		int value = 0;
		try {
			for (Buns bun : this.buns) {
				if (name.equals(bun.getName())) {
					value = bun.getPrice() * number;
					if (note > value) {
						mass = this.shortChange(note - value);
					} else {
						throw new InsufficientFundsException("Insufficient amount for payment.");
					}
				}
			}
		} catch (UnacceptableBillException ube) {
			System.out.println("There is no way to give change.");
		} catch (InsufficientFundsException ife) {
			System.out.println("Insufficient amount for payment.");
		}
		int i = 0;
		for (int j = 0; j < mass.length; j++) {
			i += (mass[j] * this.coins[j].getDenom());
		}
		if (i == (note - value)) {
			check = true;
		}
		return check;
	}
/**
* Метод shortChange.
* Создает массив из 4-х int-овых элементов. Каждый элемент "говорит", сколько монет
* кадого номинала нужно взять, чтобы выдать сдачу.
* Сначала выгребаются самые крупные монеты, а далее по списку в порядке убывания.
* @param balance Сдача, которую нужно разбить на монеты.
* @return [0] - 10-ки, [1] - 5-ки, [2] - 2-ки, [3] - рубли.
* @throws UnacceptableBillException Если не хватает монет для выдачи сдачи..
*/
	public int[] shortChange(int balance) throws UnacceptableBillException {
		int[] change = new int[4];
		int j = 0;
		for (int i = 0; i < 4; i++) {
			j += (this.coins[i].getAmount() * this.coins[i].getDenom());
		}
		if (j >= balance) {
			int num = balance;
			for (int i = 0; i < 4; i++) {
				if (this.coins[i].getAmount() > 0) {
					if (this.coins[i].getAmount() >= num / this.coins[i].getDenom()) {
						change[i] = num / this.coins[i].getDenom();
						this.coins[i].setAmount(this.coins[i].getAmount() - change[i]);
						num -= (change[i] * this.coins[i].getDenom());
					} else {
						change[i] = this.coins[i].getAmount();
						this.coins[i].setAmount(0);
						num -= (change[i] * this.coins[i].getDenom());
					}
				} else {
					change[i] = 0;
				}
			}
		} else {
			throw new UnacceptableBillException("There is no way to give change.");
		}
		return change;
	}
}