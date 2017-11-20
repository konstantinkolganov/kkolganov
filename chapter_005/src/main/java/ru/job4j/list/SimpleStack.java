package ru.job4j.list;

/**
* Класс SimpleStack.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 17.11.2017
* @version 2.0
* @param <T> Параметр типа.
*/

public class SimpleStack<T> {
/**
* Класс SimpleStack.
*/
	private Node<T> first; /**Вершина стека.*/
/**
* Метод push(). Размещает элемент в стеке.
* @param value Объект T.
*/
	public void push(T value) {
		final Node<T> firstNode = this.first;
		final Node<T> newNode = new Node(value, firstNode);
		this.first = newNode;
	}
/**
* Метод poll(). Возвращает элемент из вершины стека и удаляет его.
* @return Элемент T или пустое значение null, если стек пуст.
*/
	public T poll() {
		T result;
		final Node<T> firstNode = this.first;
		if (firstNode == null) {
			result = null;
		} else {
			result = firstNode.getElement();
			this.first = firstNode.getNext();
			firstNode.setNext(null);
		}
		return result;
	}
/**
* Статический внутренний класс Node.
* Реализует узел в связанном списке.
* @param <T> Параметр типа.
*/
	private static class Node<T> {
	/**
	* Класс Node<T>.
	*/
		private T element; /**Элемент контейнера.*/
		private Node<T> next; /**Ссылка на следующий узел.*/
	/**
	* Конструктор класса.
	* @param element Элемент.
	* @param next Ссылка на следующий узел.
	*/
		Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}
	/**
	* Метод getElement. Возвращает элемент.
	* @return Элемент.
	*/
		public T getElement() {
			return this.element;
		}
	/**
	* Метод getNext. Возвращает ссылку на следующий узел.
	* @return Node<E>.
	*/
		public Node<T> getNext() {
			return this.next;
		}
	/**
	* Метод setNext. Записывает ссылку на следующий узел.
	* @param next Node<E>.
	*/
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}