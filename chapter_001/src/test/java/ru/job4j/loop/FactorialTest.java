package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Класс FactorialTest тестирует метод calc класса Factorial при двух условиях.
* @author Konstantin Kolganov (kkilganov.92@gmail.com)
* @since 29.08.2017
* @version 1.0
*/

public class FactorialTest {
/**
* Тест метода calc.
* При условии, что он принимает целое положительное число, отличное от нуля.
*/
	@Test
	public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
		// Создаем новый объект класса Factorial
		Factorial fact = new Factorial();
		// Подсчитываем значение факториала для числа 5
		int result = fact.calc(5);
		// Ожидаемое значение 120
		int expected = 120;
		// Сравнение результата с ожидаемым значением
		assertThat(result, is(expected));
	}
/**
* Тест метода calc.
* При условии, что он принимает ноль.
*/
	@Test
	public void whenCalculateFactorialForZeroThenOne() {
		// Создаем новый объект
		Factorial fact = new Factorial();
		// Метод calc принимает ноль, должен вернуть 1
		int result = fact.calc(0);
		// Сравгиваем результат с ожидаемым значением
		assertThat(result, is(1));
	}
}