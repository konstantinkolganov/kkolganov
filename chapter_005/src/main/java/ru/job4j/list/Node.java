package ru.job4j.list;

/**
* Класс Node.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 17.11.2017
* @version 2.0
* @param <T> Парамметр типа.
*/

public class Node<T> {
/**
* Класс Node<T>.
*/
	private T value; /**Сам элемент.*/
	private Node<T> next; /**Ссылка на следующий узел.*/
/**
* Конструктор класса.
* @param value Значение.
*/
	public Node(T value) {
		this.value = value;
	}
/**
* Метод getNext. Возвращает ссылку на следующий элемент списка.
* @return Объект Node<T> или null, если объект не содержит ссылку на следующий элемент.
*/
	public Node<T> getNext() {
		return this.next;
	}
/**
* Метод setNext. Присваивает переменной next ссылку на следующий элемент списка.
* @param next Node<T>.
*/
	public void setNext(Node<T> next) {
		this.next = next;
	}
/**
* Статический метод hasCycle. Определяет наличие или отсутствие замкнутости списка.
* @param first Элемент списка.
* @return Логическое true, если список замкнут, иначе - false.
*/
	public static boolean hasCycle(Node first) {
		boolean result = false;
		for (Node x = first.getNext(); x != null; x = x.getNext()) {
			if (first.equals(x)) {
				result = true;
				break;
			}
		}
		return result;
	}
}