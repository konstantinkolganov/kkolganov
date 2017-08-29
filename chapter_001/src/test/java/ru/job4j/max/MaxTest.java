package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Тестирование класса Max.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 27.08.2017
* @version 1.0
*/
public class MaxTest {
/**
* Тест на сравнение max с двумя числами.
*/
    @Test
    public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
	}
/**
* Тест на сравнение max с тремя числами.
*/
	@Test
    public void whenSecondLessFirstAndThird() {
		Max maxim = new Max();
		int result = maxim.max(3, 1, 4);
		assertThat(result, is(4));
	}
}