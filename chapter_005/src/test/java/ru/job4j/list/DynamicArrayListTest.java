package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс DynamicArrayListTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 18.11.2017
* @version 2.0
*/

public class DynamicArrayListTest {
/**
* Класс DynamicArrayListTest.
*/
	private DynamicArrayList<Integer> darList; /**Ссылка на объект DynamicArrayList.*/
	private Iterator<Integer> it; /**Сылка на интерфейс итератора.*/
/**
* Метод setUp() создает новый динамический массив.
* И добавляет в него 12 элементов. Начальная емкость массива 10 элементов.
* Заодно проверяется автоматическое расширение массива.
*/
	@Before
	public void setUp() {
		darList = new DynamicArrayList<Integer>();
		darList.add(1);
		darList.add(2);
		darList.add(3);
		darList.add(4);
		darList.add(5);
		darList.add(6);
		darList.add(7);
		darList.add(8);
		darList.add(9);
		darList.add(10);
		darList.add(11);
		darList.add(12);
	}
/**
* Метод get() возвращает элемент по указанному индексу.
* Если индекс не входит в границы массива, то генерируется исключение.
*/
	@Test(expected = IndexOutOfBoundsException.class)
	public void whenCallMethodGetWithIndexThenReturnAppropriateElement() {
		assertThat(darList.get(0), is(1));
		assertThat(darList.get(1), is(2));
		assertThat(darList.get(2), is(3));
		assertThat(darList.get(3), is(4));
		assertThat(darList.get(4), is(5));
		assertThat(darList.get(5), is(6));
		assertThat(darList.get(6), is(7));
		assertThat(darList.get(7), is(8));
		assertThat(darList.get(8), is(9));
		assertThat(darList.get(9), is(10));
		assertThat(darList.get(10), is(11));
		assertThat(darList.get(11), is(12));
		darList.get(12);
	}
/**
* Если элементы еще есть, то hasNext() возвращает true, если нет - false.
* next() возвращает текущее значение.
*/
	@Test
	public void whenCallMethodHasNextReturnTrueAndCallMethodNextThenReturnElement() {
		it = this.darList.iterator();
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
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(10));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(11));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(12));
		assertThat(it.hasNext(), is(false));
	}
/**
* Если пробежаться по всем элементам только методом next().
* То он сгенерирует исключение, когда выйдет за границы массива.
*/
	@Test(expected = NoSuchElementException.class)
	public void whenCallMethodNextOfIteratorLessMethodHasNextThenAtTheEndOfGeneratesException() {
		it = this.darList.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(6));
		assertThat(it.next(), is(7));
		assertThat(it.next(), is(8));
		assertThat(it.next(), is(9));
		assertThat(it.next(), is(10));
		assertThat(it.next(), is(11));
		assertThat(it.next(), is(12));
		it.next();
	}
/**
* Если hasNext() вызвать несколько раз подряд, то каждый раз он вернет одинаковые значения.
*/
	@Test
	public void whenCallMethodHasNextRepeatedlyThenReturnTheSameValue() {
		it = this.darList.iterator();
		assertThat(it.hasNext(), is(true));
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
		assertThat(it.next(), is(10));
		assertThat(it.next(), is(11));
		assertThat(it.next(), is(12));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
		assertThat(it.hasNext(), is(false));
	}
}