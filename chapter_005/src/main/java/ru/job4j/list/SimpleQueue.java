package ru.job4j.list;

/**
* Класс SimpleQueue.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 17.11.2017
* @version 2.0
* @param <T> Параметр типа.
*/

public class SimpleQueue<T> {
/**
* Класс SimpleQueue.
*/
	private Node<T> first; /**Первый элемент очереди.*/
	private Node<T> last; /**Последний элемент очереди.*/
/**
* Метод push(). Вводит новый элемент в конец очереди.
* @param value Объект T.
*/
	public void push(T value) {
		final Node<T> lastNode = this.last;
		final Node<T> newNode = new Node<T>(lastNode, value, null);
		this.last = newNode;
		if (lastNode == null) {
			this.first = newNode;
		} else {
			lastNode.setNext(newNode);
		}
	}
/**
* Метод poll(). Возвращает элемент из головы очереди.
* @return Элемент T или пустое значение null, если очередь пуста.
*/
	public T poll() {
		T result;
		final Node<T> firstNode = this.first;
		if (firstNode == null) {
			result = null;
		} else {
			result = firstNode.getElement();
			this.first = firstNode.getNext();
			if (this.first == null) {
				this.last = null;
			} else {
				this.first.setPrev(null);
			}
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
		private Node<T> prev; /**Ссылка на предыдущий узел.*/
		private Node<T> next; /**Ссылка на следующий узел.*/
	/**
	* Конструктор класса.
	* @param element Элемент.
	* @param prev Ссылка на предыдущий узел.
	* @param next Ссылка на следующий узел.
	*/
		Node(Node<T> prev, T element, Node<T> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	/**
	* Метод setPrev. Записывает новую ссылку на предыдущий узел.
	* @param prev Node<T>.
	*/
		public void setPrev(Node<T> prev) {
			this.prev = prev;
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