package ru.job4j.generic;

import java.lang.IndexOutOfBoundsException;

/**
* Класс SimpleArray.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 14.11.2017
* @version 2.0
* @param <T> Generic.
*/

public class SimpleArray<T> {
/**
* Класс SimpleArray<T>.
*/
	private static final int DEFAULT_CAPACITY = 10; /**Начальная емкость массива.*/
	private Object[] arrayElements; /**Хранилище объетов.*/
	private int size; /**Текущий размер массива.*/
	private int index = 0; /**Текущий индекс.*/
/**
* Конструктор класса.
*/
	public SimpleArray() {
		this.arrayElements = new Object[DEFAULT_CAPACITY];
		this.size = this.arrayElements.length;
	}
/**
* Метод add(). Добавляет объект в масссив.
* @param model Новый объект.
* @return Добавленный объект.
*/
	public T add(T model) {
		this.rangeThisIndex();
		this.arrayElements[this.index++] = model;
		return model;
	}
/**
* Метод update().
* Заменяет элемент массива заданным объектом model, у которого такой же id.
* @param model Объект T с идентичным id.
* @return Прежний элемент или null, если элемента с таким же id не найдено.
* @throws IndexOutOfBoundsException Если индекс не входит в границы массива.
*/
	public T update(T model) {
		T element = null;
		for (int i = 0; i < this.index; i++) {
			if (model.equals(this.get(i))) {
				element = this.get(i);
				this.arrayElements[i] = model;
				break;
			}
		}
		return element;
	}
/**
* Метод delete(). Удаляет элемент с заданным id.
* @param id Номер id элемента.
* @return Логическое true, если элемент удален, а иначе - false.
*/
	public boolean delete(String id) {
		boolean result = false;
		Base base;
		for (int i = 0; i < this.index; i++) {
			base = (Base) this.get(i);
			if (id.equals(base.getId())) {
				this.shiftElementsArray(i);
				result = true;
			}
		}
		return result;
	}
/**
* Метод get. Возвращает элемент по индексу.
* @param index Индекс искомого элемента.
* @return T Элемент.
* @throws IndexOutOfBoundsException Если индекс не входит в границы массива.
*/
	public T get(int index) throws IndexOutOfBoundsException {
		this.rangeCheckIndex(index);
		return (T) this.arrayElements[index];
	}
/**
* Приватный метод rangeThisIndex().
* Если индекс массива равен верхней границе, то увеличивает его на 10 элементов.
*/
	private void rangeThisIndex() {
		if (this.rangeCheckSize()) {
			Object[] tmp = new Object[this.size + DEFAULT_CAPACITY];
			System.arraycopy(this.arrayElements, 0, tmp, 0, this.size - 1);
			this.arrayElements = tmp;
			this.size = this.arrayElements.length;
			tmp = null;
		}
	}
/**
* Приватный метод rangeCheckSize().
* Проверяет, входит ли заданный индекс в границы массива.
* @return Boolean.
*/
	private boolean rangeCheckSize() {
		return this.index == this.size - 1;
	}
/**
* Приватный метод rangeCheckIndex().
* Проверяет, входит ли заданный индекс в диапазон от 0 до this.index.
* @param index Индекс.
* @throws IndexOutOfBoundsException Если индекс некорректный.
*/
	private void rangeCheckIndex(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.index) {
			throw new IndexOutOfBoundsException("Overflowing the array.");
		}
	}
/**
* Приватный метод shiftElementsArray().
* При удалении элемента все последующие смещает на одну позицию назад..
* @param index Индекс удаляемого элемента.
*/
	private void shiftElementsArray(int index) {
		Object[] tmp = new Object[this.size - (index + 1)];
		System.arraycopy(this.arrayElements, index + 1, tmp, 0, tmp.length);
		System.arraycopy(tmp, 0, this.arrayElements, index, tmp.length);
		this.index--;
	}
}