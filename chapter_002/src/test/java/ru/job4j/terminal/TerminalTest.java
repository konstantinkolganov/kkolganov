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
		// Добавляем в объект плюшки и монеты
		terminal.fillBuns();
		terminal.fillCoins();
		// Выбираем 3 плюшки с кремом и вносим 100 рублей. Должно вернуться true.
		boolean result = terminal.processApp("S kremom", 3, 100);
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
		// Добавляем в объект монеты
		terminal.fillCoins();
		// Автомат должен выдать 109 рублей сдачи.
		int[] result = null;
		try {
			result = terminal.shortChange(85);
		} catch (UnacceptableBillException ube) {
			System.out.println("There is no way to give change.");
		}
		// Из выданных монет 10 штук 10-тирублевых.
		assertThat(result[0], is(8));
	}
/**
* После пополнения монет, в терминале должно быть 10 штук 10-тирублевых.
*/
	@Test
	public void whenReplenishCoinsThenTenRubleIsTenCoins() {
		// Новый объект класса Terminal
		Terminal terminal = new Terminal();
		// Добавляем в объект монеты
		terminal.fillCoins();
		// Заставим автомат выдать сдачу 109 рублей.
		// В автомате не должно остаться 10-рублевых монет
		try {
			terminal.shortChange(109);
		} catch (UnacceptableBillException ube) {
			System.out.println("There is no way to give change.");
		}
		// Добавляем новых монет
		terminal.fillCoins();
		// Количество 10-тирублевых восполнено.
		int result = terminal.testCoins(10);
		assertThat(result, is(10));
	}
}