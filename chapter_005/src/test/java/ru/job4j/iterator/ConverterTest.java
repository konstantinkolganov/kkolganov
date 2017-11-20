package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс ConverterTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 13.11.2017
* @version 2.0
*/

public class ConverterTest {
/**
* Класс ConverterTest.
*/
	private Iterator<Integer> it; /**Переменная типа IteratorInteger(Iterator<Iterator>).*/
/**
* Создание итератора итераторов InsertedIterator.
*/
	@Before
	public void setUp() {
		Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
		Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
		Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
		Iterator<Iterator<Integer>> inIt = Arrays.asList(it1, it2, it3).iterator();
		Converter converter = new Converter();
		it = converter.convert(inIt);
	}
/**
* При вызове next() возвращает значение, а hasNext() true, если еще есть элементы.
*/
	@Test
	public void whenCallMethodNextReturnIntNumber() {
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
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(6));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(7));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(8));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(9));
		assertThat(it.hasNext(), is(false));
	}
/**
* Если hasNext вызывать несколько раз подряд, то он будет возвращать одно и то же значение.
*/
	@Test
	public void whenCallMethodHasNextRepeatedlyThenReturnSameResult() {
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(6));
		assertThat(it.next(), is(7));
		assertThat(it.next(), is(8));
		assertThat(it.next(), is(9));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
	}
/**
* Если не использовать hasNext(), то можно обойтись одним next().
* В конце он сгенерирует исключение.
*/
	@Test(expected = NoSuchElementException.class)
	public void whenCallMethodNextThenMovesThroughAnArrayIndependentlyMethodHasNext() {
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(6));
		assertThat(it.next(), is(7));
		assertThat(it.next(), is(8));
		assertThat(it.next(), is(9));
		it.next();
	}
}