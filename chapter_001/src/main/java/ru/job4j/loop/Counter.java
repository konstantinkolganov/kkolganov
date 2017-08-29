package ru.job4j.loop;

/**
* Класс Counter подсчитывает сумму четных чисел для заданного диапазона чисел.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 29.08.2017
* @version 1.0
*/
public class Counter {
/**
* Класс Counter.
* Поле sumEven и метод add.
*/
	private int sumEven; // Поле класса для хранения суммы четных чисел.
/**
* Метод для подсчета суммы четных чисел.
* @param start Начало диапазона.
* @param finish Конец диапазона.
* @return Сумма четных чисел диапазона.
*/
	public int add(int start, int finish) {
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				this.sumEven += i;
			}
		}
		return this.sumEven;
	}
}