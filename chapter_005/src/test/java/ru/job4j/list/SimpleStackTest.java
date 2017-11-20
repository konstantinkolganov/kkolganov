package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс SimpleStackTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 18.11.2017
* @version 2.0
*/

public class SimpleStackTest {
/**
* Класс SimpleStackTest.
*/
	private SimpleStack<Integer> sst; /**Ссылка на объект SimpleStack.*/
/**
* Метод создает новый объект SimpleStack<Integer>. И заполняет его 5-ю элементами.
*/
	@Before
	public void setUp() {
		sst = new SimpleStack<Integer>();
		sst.push(1);
		sst.push(2);
		sst.push(3);
		sst.push(4);
		sst.push(5);
	}
/**
* При вызове метода poll() элементы извлекаются в обратном порядке.
* То есть, если элемент добавлен первым, то он вернется последним.
*/
	@Test
	public void whenElementFirstEnteredTheStackThenOutOfTheStackIsAlsoTheLast() {
		assertThat(sst.poll(), is(5));
		assertThat(sst.poll(), is(4));
		assertThat(sst.poll(), is(3));
		assertThat(sst.poll(), is(2));
		assertThat(sst.poll(), is(1));
	}
/**
* Тот же самый стек sst заполнить теми же элементами, что и в первый раз.
* Но в обратном порядке. И извлечь их из стека.
*/
	@Test
	public void whenAddTheSameElementInReverseOrder() {
		sst.push(5);
		sst.push(4);
		sst.push(3);
		sst.push(2);
		sst.push(1);
		assertThat(sst.poll(), is(1));
		assertThat(sst.poll(), is(2));
		assertThat(sst.poll(), is(3));
		assertThat(sst.poll(), is(4));
		assertThat(sst.poll(), is(5));
	}
}