package ru.job4j.terminal;

/**
* Класс Utils содержит проверки на возможность приобрести плюшки при наличии некоторых условий.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 16.10.2017
* @version 2.0
*/

public class Utils {
/**
* Класс Utils.
*/
	private Terminal terminal; /**Объект терминал.*/
/**
* Конструктор класса.
* @param terminal Объект Terminal.
*/
	public Utils(Terminal terminal) {
		this.terminal = terminal;
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
		Coins[] arrCoins = this.terminal.getCoins();
		Buns[] arrBuns = this.terminal.getBuns();
		boolean check = false;
		int[] mass = null;
		int value = 0;
		try {
			for (Buns bun : arrBuns) {
				if (name.equals(bun.getName())) {
					value = bun.getPrice() * number;
					if (note > value) {
						mass = this.shortChange(note - value);
						bun.setNumber(bun.getNumber() - number);
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
			i += (mass[j] * arrCoins[j].getDenom());
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
		Coins[] arrCoins = this.terminal.getCoins();
		int[] change = new int[4];
		int j = 0;
		for (int i = 0; i < arrCoins.length; i++) {
			j += (arrCoins[i].getAmount() * arrCoins[i].getDenom());
		}
		if (j >= balance) {
			int num = balance;
			for (int i = 0; i < 4; i++) {
				if (arrCoins[i].getAmount() > 0) {
					if (arrCoins[i].getAmount() >= num / arrCoins[i].getDenom()) {
						change[i] = num / arrCoins[i].getDenom();
						arrCoins[i].setAmount(arrCoins[i].getAmount() - change[i]);
						num -= (change[i] * arrCoins[i].getDenom());
					} else {
						change[i] = arrCoins[i].getAmount();
						arrCoins[i].setAmount(0);
						num -= (change[i] * arrCoins[i].getDenom());
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