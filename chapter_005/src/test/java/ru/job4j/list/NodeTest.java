package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс NodeTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 18.11.2017
* @version 2.0
*/

public class NodeTest {
/**
* Класс NodeTest.
*/
	@Test
	public void whenLinkedListIsCloseThenMethodCycleReturnTrue() {
		// Создать 5 узлов связанного списка
		Node<Double> third = new Node<>(3.0);
		Node<Double> fourth = new Node<>(4.0);
		Node<Double> fifth = new Node<>(5.0);
		Node<Double> first = new Node<>(1.0);
		Node<Double> second = new Node<>(2.0);
		// Замкнуть их в кольцо
		third.setNext(fourth);
		fourth.setNext(fifth);
		fifth.setNext(first);
		first.setNext(second);
		second.setNext(third);
		// Проверка цикличности возвращает true
		assertThat(Node.hasCycle(fifth), is(true));
		assertThat(Node.hasCycle(second), is(true));
	}
}