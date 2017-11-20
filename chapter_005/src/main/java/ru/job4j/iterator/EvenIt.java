package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Класс EvenIt. Итератор четных чисел.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.11.2017
* @version 2.0
*/

public class EvenIt implements Iterator {
/**
* Класс EvenIt.
*/
	private final int[] array; /**Массив целых произвольных чисел.*/
	private int index = 0; /**Итератор массива.*/
/**
* Конструктор класса.
* @param array Массив целых произвольных чисел.
*/
	public EvenIt(final int[] array) {
		this.array = array;
	}
/**
* Метод hasNext.
* @return true, если в массиве еще содержатся четные числа.
*/
	public boolean hasNext() {
		boolean result;
		if (this.index < this.array.length) {
			int currentIndex = this.index;
			result = false;
			while (currentIndex < this.array.length) {
				if (this.array[currentIndex] % 2 == 0) {
					result = true;
					break;
				} else {
					currentIndex++;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
/**
* Метод next. Возвращает четное число из массива.
* @return Следующее четное число из массива.
* @throws NoSuchElementException Если четных элементов больше нет.
*/
	public Integer next() throws NoSuchElementException {
		int element = 0;
		if (this.index < this.array.length) {
			while (this.index <= this.array.length) {
				if (this.index != this.array.length) {
					if (this.array[this.index] % 2 == 0) {
						element = this.array[this.index++];
						break;
					}
					this.index++;
				} else {
					throw new NoSuchElementException("The array no longer contains elements.");
				}
			}
		} else {
			throw new NoSuchElementException("The array no longer contains elements.");
		}
		return new Integer(element);
	}
}