package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс PrimeItTest. Тест итератора простых чисел.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 13.11.2017
* @version 2.0
*/

public class PrimeItTest {
/**
* Класс PrimeItTest.
*/
	private Iterator it; /**Ссылка на интерфейс Iterator.*/
/**
* Создание нового объекта PrimeIt.
*/
	@Before
	public void setUp() {
		it = new PrimeIt(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 11, 31});
	}
/**
* При каждом вызове next() возвращает текущий элемент.
* при вызове hasNext() возвращает true, если еще есть элементы.
*/
	@Test
	public void whenCallMethodNextThenReturnPrimeNumbers() {
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(3));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(5));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(11));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(31));
		assertThat(it.hasNext(), is(false));
	}
/**
* Тест на последовательный проход по всем элементам массива.
* В конце генерирует исключение NoSuchElementException.
*/
	@Test(expected = NoSuchElementException.class)
	public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
		it = new PrimeIt(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 11, 31});
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(11));
		assertThat(it.next(), is(31));
		it.next();
	}
/**
* Если hasNext() вызывать несколько раз подряд.
* То каждый раз он вернет одно и то же значение true или false.
*/
	@Test
	public void whenCallMethodHasNextRepeatedlyThenReturnSameResult() {
		it = new PrimeIt(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 11, 31});
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(11));
		assertThat(it.next(), is(31));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
	}
/**
* Если в массиве нет ни одного простого числа, то hasNext() возвращает false.
*/
	@Test
	public void whenInArrayNotIsPrimeNumbersThenFalse() {
		it = new PrimeIt(new int[]{1, 4, 6, 8, 9, 10});
		assertThat(it.hasNext(), is(false));
	}
}