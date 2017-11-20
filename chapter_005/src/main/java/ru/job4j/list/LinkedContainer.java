package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Класс LinkedContainer.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 17.11.2017
* @version 2.0
* @param <E> Параметр типа.
*/

public class LinkedContainer<E> implements Iterable<E> {
/**
* Класс LinkedContainer.
*/
	private Node<E> first; /**Первый элемент списка.*/
	private Node<E> last; /**Последний элемент списка.*/
	private int size = 0; /**Количество элементов в списке.*/
/**
* Метод add. Добавляет новый элемент в список.
* @param value Объект E.
*/
	public void add(E value) {
		final Node<E> early = this.last;
		final Node<E> newNode = new Node<>(early, value, null);
		this.last = newNode;
		if (early == null) {
			this.first = newNode;
		} else {
			early.setNext(newNode);
		}
		this.size++;
	}
/**
* Метод get. Возвращает элемент по индексу.
* @param index Индекс.
* @return Объект E.
* @throws IndexOutOfBoundsException Если индекс некорректный.
*/
	public E get(int index) throws IndexOutOfBoundsException {
		this.checkElementIndex(index);
		Node<E> node = this.first;
		E result = null;
		if (index == 0) {
			result = node.getElement();
		} else if (index == this.size - 1) {
			result = this.last.getElement();
		} else {
			for (int i = 0; i < index; i++) {
				node = node.getNext();
			}
			result = node.getElement();
		}
		return result;
	}
/**
* Метод iterator. Возвращает итератор коллекции.
* @return Iterator<E>.
*/
	public Iterator<E> iterator() {
		return new LinkedIterator(this.first);
	}
/**
* Класс Node<E>. Внутренний статический.
* Реализует узел в связанном списке.
* @param <E> Параметр типа.
*/
	private static class Node<E> {
	/**
	* Класс Node<E>.
	*/
		private E element; /**Элемент контейнера.*/
		private Node<E> prev; /**Ссылка на предыдущий узел.*/
		private Node<E> next; /**Ссылка на следующий узел.*/
	/**
	* Конструктор класса.
	* @param prev Ссылка на предыдущий узел.
	* @param element Элемент.
	* @param next Ссылка на следующий узел.
	*/
		Node(Node<E> prev, E element, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	/**
	* Метод getElement. Возвращает элемент.
	* @return Элемент.
	*/
		public E getElement() {
			return this.element;
		}
	/**
	* Метод getNext. Возвращает ссылку на следующий узел.
	* @return Node<E>.
	*/
		public Node<E> getNext() {
			return this.next;
		}
	/**
	* Метод setNext. Записывает ссылку на следующий узел.
	* @param next Node<E>.
	*/
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
/**
* Класс LinkedIterator. Внутренний нестатический.
* Итератор контейнера LinkedContainer.
* @param <E> Параметр типа.
*/
	private class LinkedIterator<E> implements Iterator<E> {
	/**
	* Класс LinkedIterator.
	*/
		private Node<E> next; /**Текущий элемент.*/
	/**
	* Конструктор класса.
	* Инициализирует next первым элементом first.
	* @param first первый элемент.
	*/
		LinkedIterator(Node<E> first) {
			this.next = first;
		}
	/**
	* Метод hasNext.
	* @return Логическое true, если еще есть элементы, иначе - false.
	*/
		public boolean hasNext() {
			return this.next != null;
		}
	/**
	* Метод next. Возвращает текущий элемент коллекции.
	* @return Объект E.
	* @throws NoSuchElementException Если в коллекции больще нет элементов.
	*/
		public E next() throws NoSuchElementException {
			E result = null;
			if (this.next != null) {
				result = this.next.getElement();
				this.next = this.next.getNext();
			} else {
				throw new NoSuchElementException("The array no longer contains elements.");
			}
			return result;
		}
	}
/**
* Метод checkElementIndex.
* Выбрасывает исключение, если значение индекса не входит в границы массива.
* @param index Индекс.
* @throws IndexOutOfBoundsException Исключение.
*/
	private void checkElementIndex(int index) throws IndexOutOfBoundsException {
		if (!this.checkPositionIndex(index)) {
			throw new IndexOutOfBoundsException("Overflowing the array.");
		}
	}
/**
* Приватный метод checkPositionIndex().
* Проверяет, входит ли заданный индекс в границы массива.
* @param index Индекс.
* @return Логическое true, если индекс входит в границы массива.
*/
	private boolean checkPositionIndex(int index) {
		return index >= 0 && index < this.size;
	}
}