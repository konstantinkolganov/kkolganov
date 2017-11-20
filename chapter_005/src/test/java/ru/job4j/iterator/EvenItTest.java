package ru.job4j.iterator;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс EvenItTest. Тест итератора четных чисел.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 13.11.2017
* @version 2.0
*/

public class EvenItTest {
/**
* Класс EvenItTest.
*/
	private EvenIt it; /**Ссылка на итератор EvenIt.*/
/**
* Создание нового объекта EvenIt.
*/
	@Before
	public void setUp() {
		it = new EvenIt(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15});
	}
/**
* При каждом вызове next() возвращает четное число.
*/
	@Test
	public void whenCallMethodNextThenReturnEvenNumbers() {
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(4));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(6));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(8));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(10));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(12));
		assertThat(it.hasNext(), is(false));
	}
/**
* Тест на последовательный проход по всем элементам массива.
* В конце генерирует исключение NoSuchElementException.
*/
	@Test(expected = NoSuchElementException.class)
	public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(6));
		assertThat(it.next(), is(8));
		assertThat(it.next(), is(10));
		assertThat(it.next(), is(12));
		it.next();
	}
/**
* Если hasNext() вызывать несколько раз подряд.
* То каждый раз он вернет одно и то же значение true или false.
*/
	@Test
	public void whenCallMethodHasNextRepeatedlyThenReturnSameResult() {
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(6));
		assertThat(it.next(), is(8));
		assertThat(it.next(), is(10));
		assertThat(it.next(), is(12));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
	}
/**
* Если в массиве нет ни одного четного числа, то hasNext() возвращает false.
*/
	@Test
	public void whenInArrayIsNotEvenNumbersThenFalse() {
		it = new EvenIt(new int[]{1, 3, 5, 7});
		assertThat(it.hasNext(), is(false));
	}
}