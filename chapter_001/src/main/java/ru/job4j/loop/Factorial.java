package ru.job4j.loop;

/**
* Класс Factorial расчитывает факториал целого положительного числа.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 29.08.2017
* @version 1.0
*/
public class Factorial {
/**
* Класс Factorial.
* Поле result и метод calc.
*/
	private int result; // поле для хранения расчитанного факториала
/**
* Comment.
*/
	public Factorial() {
		this.result = 1;
	}
/**
* Метод calc принимает число и расчитывает для него факториал.
* @param n Целое положительное число.
* @return Расчтанный факториал.
*/
	public int calc(int n) {
		if (n != 0) {
			for (int i = 1; i <= n; i++) {
				this.result *= i;
			}
		}
		return this.result;
	}
}