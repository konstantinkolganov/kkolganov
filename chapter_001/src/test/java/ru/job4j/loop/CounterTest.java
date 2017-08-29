package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс CounterTest тестирует метод класса Counter.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 29.08.2017
* @version 1.0
*/
public class CounterTest {
/**
* Тест метода add класса Counter.
*/
	@Test
	public void whenSumEvenNumbersFromOneToTenThenThirty() {
		// Создаем новый объект класса Counter
		Counter count = new Counter();
		// Вычисляем сумму четных чисел в диапазоне от 1 до 10
		int result = count.add(1, 10);
		// Ожидаемое значение
		int expected = 30;
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
}