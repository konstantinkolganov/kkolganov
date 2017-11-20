package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Класс IteratorsInteger. Реализует интерфейс Iterator<Integer>.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.11.2017
* @version 2.0
* @param <Integer> Параметр типа.
*/

public class IteratorInteger<Integer> implements Iterator<Integer> {
/**
* Класс IteratorsConvert.
*/
	private final Integer[] array; /**Массив итераторов.*/
	private int index = 0; /**Индекс массива.*/
/**
* Конструктор класса.
* @param array Массив итераторов.
*/
	public IteratorInteger(final Integer[] array) {
		this.array = array;
	}
/**
* Метод hasNext. Проверяет наличие элементов в массиве.
* @return Логическое true, если в массиве еще есть елементы.
* А иначе - false.
*/
	public boolean hasNext() {
		return this.index < this.array.length;
	}
/**
* Метод next. Возвращает текущий элемент массива.
* И увеличивает индекс на единицу.
* @return Элемент.
* @throws NoSuchElementException Если в массиве больше нет элементов.
*/
	public Integer next() throws NoSuchElementException {
		Integer result;
		if (this.index < this.array.length) {
			result = this.array[this.index++];
		} else {
			throw new NoSuchElementException("The array no longer contains elements.");
		}
		return result;
	}
}