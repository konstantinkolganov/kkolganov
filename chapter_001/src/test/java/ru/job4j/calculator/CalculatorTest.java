package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Тестирование класса Calculator.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 23.08.2017
* @version 1.0
*/

public class CalculatorTest {
/**
* Тест на сложение (метод add).
*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
/**
* Тест на вычитание (метод Subtract).
*/
    @Test
	public void whenSubtractOneOtOneThenZero() {
		Calculator calc = new Calculator();
		calc.subtract(1D, 1D);
		double result = calc.getResult();
		double expected = 0D;
		assertThat(result, is(expected));
	}
/**
* Тест на деление (метод div).
*/
	@Test
	public void whenOneDelitnaOneThenOne() {
		Calculator calc = new Calculator();
		calc.div(1D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
/**
* Тест на умножение (метод multiple).
*/
	@Test
	public void whenOneUmnozhitOneThenOne() {
		Calculator calc = new Calculator();
		calc.multiple(1D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
}