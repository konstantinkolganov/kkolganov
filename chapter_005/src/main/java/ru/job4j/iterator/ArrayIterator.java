package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Класс Iterator. Итератор для двухмерного массива int[][].
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 11.11.2017
* @version 2.0
*/

public class ArrayIterator implements Iterator {
/**
* Класс ArrayYterator.
*/
	private final int[][] array; /**Двухмерный массив.*/
	private int vertical = 0; /**Индекс текущей строки.*/
	private int horizontal = 0; /**Индекс текущего столбца.*/
	private int lengthVer; /**Длина массива по вертикали.*/
/**
* Конструктор класса.
* @param array Двухмерный целочисленный массив.
*/
	public ArrayIterator(final int[][] array) {
		this.array = array;
		this.lengthVer = array.length;
	}
/**
* Метод hasNext. Проверяет, есть ли еще в массиве элементы.
* @return true, если в коллекции еще иммеются элементы.
*/
	public boolean hasNext() {
		boolean result = false;
		// Если checked() возвращает 1, то hasNext возвращает true.
		if (this.checked() == 1) {
			result = true;
		// Если checked, возвращает 2, то hasNext возвращает true.
		} else if (this.checked() == 2) {
			result = true;
		// Если checked, возвращает 3, то hasNext возвращает true.
		} else if (this.checked() == 3) {
			result = true;
		// Если checked, возвращает 0, то hasNext возвращает false.
		} else if (this.checked() == 0) {
			result = false;
		}
		return result;
	}
/**
* Метод next. Возвращает текущий элемент из массива.
* @return Элемент массива array.
* @throws NoSuchElementException Если в массиве беольше нет элементов.
*/
	public Integer next() throws NoSuchElementException {
		int result = 0;
		// Если checked() возвращает 1, то элемент - последний в массиве. Он возвращается.
		// После чего, индексы увеличиваются на единицу.
		// Чтобы при следующем вызове метод hasNext() вернул false или next() сгенерировал исключение.
		if (this.checked() == 1) {
			result = this.array[this.vertical++][this.horizontal++];
		// Если checked() возвращает 2, то элемент возвращается,
		// а указатель переходит в начало следующей строки.
		} else if (this.checked() == 2) {
			result = this.array[this.vertical++][this.horizontal];
			this.horizontal = 0;
		// Если checked() возвращает 3, то индекс столбца увеличивается на 1.
		} else if (this.checked() == 3) {
			result = this.array[this.vertical][this.horizontal++];
		// Если checked() возвращает 0, то генерируется исключение.
		} else if (this.checked() == 0) {
			throw new NoSuchElementException("The array no longer contains elements.");
		}
		return new Integer(result);
	}
/**
* Метод checked. Проверка индексов массива.
* @return Число от 0 до 3, в зависимости от результата проверки.
*/
	private int checked() {
		int result;
		// Если элемент - последний в массиве.
		if (this.vertical == this.lengthVer - 1 && this.horizontal == this.array[this.vertical].length - 1) {
			result = 1;
		// Если строка не последняя, а столбец - последний.
		} else if (this.vertical < this.lengthVer - 1 && this.horizontal == this.array[this.vertical].length - 1) {
			result = 2;
		// Если индекс строки в пределах длины массива, а индекс столбца не последний.
		} else if (this.vertical < this.lengthVer && this.horizontal < this.array[this.vertical].length - 1) {
			result = 3;
		// Если индексы строки и столбца выходят за пределы массива, то возвращается 0.
		} else {
			result = 0;
		}
		return result;
	}
}