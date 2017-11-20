package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс LinkedContainerTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 18.11.2017
* @version 2.0
*/

public class LinkedContainerTest {
/**
* Класс LinkedContainerTest.
*/
	private LinkedContainer<Integer> contain; /**Ссылка на объект LinkedContainer.*/
	private Iterator<Integer> it; /**Ссылка на итератор.*/
/**
* Создаем контейнер LinkedContainer<Integer> и добавляем в него элементы.
* Получаем итератор для обхода всех элементов.
*/
	@Before
	public void setUp() {
		this.contain = new LinkedContainer<Integer>();
		contain.add(1);
		contain.add(2);
		contain.add(3);
		contain.add(4);
		contain.add(5);
	}
/**
* Метод get() возвращает значение по указанному индексу.
* Если индекс некорректный, то генерирует исключение.
*/
	@Test(expected = IndexOutOfBoundsException.class)
	public void whenCallMethodGetWithIndexThenReturnElementAtTheSpecifiedIndex() {
		assertThat(contain.get(0), is(1));
		assertThat(contain.get(1), is(2));
		assertThat(contain.get(2), is(3));
		assertThat(contain.get(3), is(4));
		assertThat(contain.get(4), is(5));
		contain.get(5);
	}
/**
* Если элементы еще есть, то hasNext() возвращает true, если нет - false.
* next() возвращает текущее значение.
*/
	@Test
	public void whenCallMethodHasNextReturnTrueAndCallMethodNextThenReturnElement() {
		it = this.contain.iterator();
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(1));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(3));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(4));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(5));
		assertThat(it.hasNext(), is(false));
	}
/**
* Если пробежаться по всем элементам только методом next().
* То он сгенерирует исключение, когда выйдет за границы списка.
*/
	@Test(expected = NoSuchElementException.class)
	public void whenCallMethodNextOfIteratorLessMethodHasNextThenAtTheEndOfGeneratesException() {
		it = this.contain.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		it.next();
	}
/**
* Если hasNext() вызвать несколько раз подряд, то каждый раз он вернет одинаковые значения.
*/
	@Test
	public void whenCallMethodHasNextRepeatedlyThenReturnTheSameValue() {
		it = this.contain.iterator();
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
	}
}