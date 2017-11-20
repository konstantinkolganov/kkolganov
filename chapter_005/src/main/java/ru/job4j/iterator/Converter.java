package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Класс Convert.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 12.11.2017
* @version 2.0
*/

public class Converter {
/**
* Класс Convert.
*/
	private final int increment = 10; /**Количество элементов, на которое увеличивается массив.*/
	private Integer[] array; /**Массив для временного хранения элементов Iterator<Integer>.*/
	private int index; /**Индекс текущего элемента.*/
	private int size; /**Размер массива.*/
/**
* Конструктор класса.
*/
	public Converter() {
		this.array = new Integer[20];
		this.size = this.array.length;
	}
/**
* Метод convert. Складывает элементы Iterator<Iterator<Integer>> в Iterator<Integer>.
* @param it Итератор итераторов Integer.
* @return Итератор Integer.
* @throws NoSuchElementException На всякий случай.
*/
	public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) throws NoSuchElementException {
		Iterator<Integer> itInt; // Для хранения ссылки на Iterator<Integer>.
		while (it.hasNext()) {
			itInt = it.next();
			while (itInt.hasNext()) {
				if (index < this.size - 1) {
					this.array[this.index++] = itInt.next();
				}
				if (index == this.size - 1) {
					this.incArrayCapacity();
					this.array[this.index++] = itInt.next();
				}
			}
		}
		Iterator<Integer> iterator = new IteratorInteger(this.cutArray());
		this.renovation();
		return iterator;
	}
/**
* Метод incArrayCapacity.
* Увеличивает размер массива на величину инкремента.
*/
	private void incArrayCapacity() {
		Integer[] tmp = new Integer[this.size + this.increment];
		System.arraycopy(this.array, 0, tmp, 0, this.array.length - 1);
		this.array = tmp;
		this.size = this.array.length;
		tmp = null;
	}
/**
* Метод cutArray.
* Создает обрезанную копию действующего массива без пустых незадействованных элементов.
* @return Обрезанный массив Integer[].
*/
	private Integer[] cutArray() {
		int mark = 0;
		for (int i = this.size - 1; i != 0; i--) {
			if (this.array[i] != null) {
				mark = i;
				break;
			}
		}
		Integer[] copyArray = Arrays.copyOf(this.array, this.size - (this.size - 1 - mark));
		return copyArray;
	}
/**
* Метод renovation. Обновляет массив this.array.
*/
	private void renovation() {
		this.array = null;
		this.size = 0;
		this.array = new Integer[20];
		this.size = this.array.length;
	}
}