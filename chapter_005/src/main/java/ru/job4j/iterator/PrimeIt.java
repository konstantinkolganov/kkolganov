package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Класс PrimeIt. Итератор простых чисел.
* В поиске простого числа используется "Малая теорема Ферма."
* "(a^p - a) % p != 0", где a - натуральное число, а p - простое.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.11.2017
* @version 2.0
*/

public class PrimeIt implements Iterator {
/**
* Класс PrimeIt.
*/
	private final int[] array; /**Массив целых чисел.*/
	private int index = 0; /**Счетчик массива.*/
/**
* Конструктор класса.
* @param array Массив целых чисел.
*/
	public PrimeIt(final int[] array) {
		this.array = array;
	}
/**
* Метод hasNext. Проверяет наличие простых чисел среди оставшихся элементах массива.
* @return Если числа еще есть, то true, а иначе - false.
*/
	public boolean hasNext() {
		boolean result = false;
		double tmp = 0.0;
		if (this.index < this.array.length) {
			int interim = this.index;
			while (interim < this.array.length) {
				tmp = (Math.pow(2, this.array[interim]) - 2) % this.array[interim];
				if (tmp == 0 && this.array[interim] != 1 && this.array[interim] != 0) {
					result = true;
					break;
				} else {
					interim++;
				}
			}
		}
		return result;
	}
/**
* Метод next. Возвращает текущее простое число. После чего производит поиск следующего простого числа.
* И сдвигает указатель на это число.
* @return Простое число.
* @throws NoSuchElementException Если в коллекции больше нет элементов.
*/
	public Integer next() throws NoSuchElementException {
		int result = 0;
		double tmp = 0.0;
		if (this.index < this.array.length) {
			while (this.index <= this.array.length) {
				if (this.index != this.array.length) {
					tmp = (Math.pow(2, this.array[this.index]) - 2) % this.array[this.index];
					if (tmp == 0 && this.array[this.index] != 1 && this.array[this.index] != 0) {
						result = this.array[this.index++];
						break;
					} else {
						this.index++;
					}
				} else {
					throw new NoSuchElementException("The array no longer contains elements.");
				}
			}
		} else {
			throw new NoSuchElementException("The array no longer contains elements.");
		}
		return new Integer(result);
	}
}