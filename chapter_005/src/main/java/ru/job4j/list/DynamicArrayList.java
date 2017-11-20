package ru.job4j.list;

import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
* Класс DynamicArrayList.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 16.11.2017
* @version 2.0
* @param <E> Параметр типа.
*/

public class DynamicArrayList<E> implements Iterable<E> {
/**
* Класс DynamicArrayList.
*/
	private static final int DEFAULT_CAPACITY = 10; /**Начальная емкость массива.*/
	private Object[] innerArray; /**Контейнер для хранения элементов.*/
	private int size; /**Размер массива.*/
	private int index; /**Индекс массива.*/
/**
* Конструктор класса.
*/
	public DynamicArrayList() {
		this.innerArray = new Object[DEFAULT_CAPACITY];
		this.size = this.innerArray.length;
		this.index = 0;
	}
/**
* Метод add. Добавление нового элемента.
* @param value Объект E.
*/
	public void add(E value) {
		this.rangeCapacity();
		this.innerArray[this.index++] = value;
	}
/**
* Метод get. Возвращает элемент по индексу.
* Если индекс отрицательный или больше, чем размер массива, то возвращает null.
* @param index Индекс элемента.
* @return Элемент E или пустое значение null.
* @throws IndexOutOfBoundsException Если индекс не входит в границы массива.
*/
	public E get(int index) throws IndexOutOfBoundsException {
		this.rangeCheckIndex(index);
		return (E) this.innerArray[index];
	}
/**
* Метод getIterator. Возвращает итератор контейнера DinamicArrayList.
* @return Iterator<E>.
*/
	public Iterator<E> iterator() {
		Iterator<E> iter = new IteratorList<E>(this.cutArray());
		return iter;
	}
/**
* Класс IteratorList. Внутренний итератор DinamicArrayList.
* @param <E> Параметр типа.
*/
	private class IteratorList<E> implements Iterator<E> {
	/**
	* Класс IteratorList<E>.
	*/
		private final E[] array; /**Массив элементов.*/
		private int index = 0; /**Индекс.*/
	/**
	* Конструктор класса.
	* @param array Контейнер элементов E внешнего класса.
	*/
		private IteratorList(final E[] array) {
			this.array = array;
		}
	/**
	* Метод hasNext.
	* @return Если в массиве есть элементы, то true, иначе - false.
	*/
		public boolean hasNext() {
			return this.index < this.array.length;
		}
	/**
	* Метод next.
	* @return Текущий элемент E.
	* @throws NoSuchElementException Если элементов больше нет.
	*/
		public E next() throws NoSuchElementException {
			E result;
			if (this.index < this.array.length) {
				result = this.array[this.index++];
			} else {
				throw new NoSuchElementException("The array no longer contains elements.");
			}
			return result;
		}
	}
/**
* Внутренний метод rangeCapacity. Контроллирует размер массива.
* Если this.index равен индексу последнего элемента, то увеличивает массив на 10 элементов.
*/
	private void rangeCapacity() {
		if (this.index == this.size - 1) {
			Object[] tmp = new Object[this.size + DEFAULT_CAPACITY];
			System.arraycopy(this.innerArray, 0, tmp, 0, this.size - 1);
			this.innerArray = tmp;
			tmp = null;
			this.size = this.innerArray.length;
		}
	}
/**
* Приватный метод rangeCheckIndex().
* Проверяет, входит ли заданный индекс в границы массива.
* @param index Индекс.
* @throws IndexOutOfBoundsException Если индекс не входит в границы массива.
*/
	private void rangeCheckIndex(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.index) {
			throw new IndexOutOfBoundsException("Overflowing the array.");
		}
	}
/**
* Метод cutArray.
* Создает обрезанную копию действующего массива без пустых незадействованных элементов.
* @return Обрезанный массив E[].
*/
	private E[] cutArray() {
		int mark = 0;
		for (int i = this.size - 1; i != 0; i--) {
			if (this.innerArray[i] != null) {
				mark = i;
				break;
			}
		}
		E[] copyArray = (E[]) Arrays.copyOf(this.innerArray, this.size - (this.size - 1 - mark));
		return copyArray;
	}
}