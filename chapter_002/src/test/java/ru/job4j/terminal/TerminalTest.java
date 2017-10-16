package ru.job4j.terminal;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс TerminalTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.10.2017
* @version 2.0
*/

public class TerminalTest {
/**
* Класс TerminalTest.
*/
/**
* Если заказ указан верно, то получаем значение true.
*/
	@Test
	public void whenOrderIsCorrectThenReturnTrue() {
		// Новый объект класса Terminal
		Terminal terminal = new Terminal();
		Coins[] coins = new Coins[4];
		coins[0] = new Coins(10, 10);
		coins[1] = new Coins(5, 20);
		coins[2] = new Coins(2, 50);
		coins[3] = new Coins(1, 100);
		terminal.fillCoins(coins);
		Buns[] buns = new Buns[3];
		buns[0] = new Buns("S makom", 12, 15);
		buns[1] = new Buns("S kremom", 21, 15);
		buns[2] = new Buns("Bez nachinki", 8, 15);
		terminal.fillBuns(buns);
		// Выбираем 3 плюшки с кремом и вносим 100 рублей. Должно вернуться true.
		Utils utils = new Utils(terminal);
		boolean result = utils.processApp("S kremom", Constants.THREE, Constants.ONE_HUNDRED);
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(true));
	}
/**
* Если терминал выдает 85 рублей сдачи, то 10-рублевых монет получаем 8 штук.
*/
	@Test
	public void whenTerminalGiveChangeThenGiveEightCoinsTenRuble() {
		// Новый объект класса Terminal
		Terminal terminal = new Terminal();
		Coins[] coins = new Coins[4];
		coins[0] = new Coins(10, 10);
		coins[1] = new Coins(5, 20);
		coins[2] = new Coins(2, 50);
		coins[3] = new Coins(1, 100);
		terminal.fillCoins(coins);
		// Автомат должен выдать 85 рублей сдачи.
		int[] result = null;
		try {
			Utils utils = new Utils(terminal);
			result = utils.shortChange(Constants.EIGHTY_FIVE);
		} catch (UnacceptableBillException ube) {
			System.out.println("There is no way to give change.");
		}
		// Из выданных монет 8 штук 10-тирублевых.
		assertThat(result[0], is(Constants.EIGHT));
	}
/**
* После пополнения монет, в терминале должно быть 10 штук 10-тирублевых.
*/
	@Test
	public void whenReplenishCoinsThenTenRubleIsTenCoins() {
		// Новый объект класса Terminal
		Terminal terminal = new Terminal();
		Coins[] coins = new Coins[4];
		coins[0] = new Coins(10, 10);
		coins[1] = new Coins(5, 20);
		coins[2] = new Coins(2, 50);
		coins[3] = new Coins(1, 100);
		terminal.fillCoins(coins);
		Utils utils = new Utils(terminal);
		// Заставим автомат выдать сдачу 109 рублей.
		// В автомате не должно остаться 10-рублевых монет
		try {
			utils.shortChange(Constants.ONE_HUNDRED_NINE);
		} catch (UnacceptableBillException ube) {
			System.out.println("There is no way to give change.");
		}
		// Добавляем новых монет
		Coins[] fcoins = new Coins[4];
		fcoins[0] = new Coins(10, 10);
		fcoins[1] = new Coins(5, 20);
		fcoins[2] = new Coins(2, 50);
		fcoins[3] = new Coins(1, 100);
		terminal.fillCoins(fcoins);
		// Количество 10-тирублевых восполнено.
		int result = terminal.testCoins(Constants.TEN);
		assertThat(result, is(Constants.TEN));
	}
}