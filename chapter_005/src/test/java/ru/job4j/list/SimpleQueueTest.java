package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс SimpleQueueTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 18.11.2017
* @version 2.0
*/

public class SimpleQueueTest {
/**
* Класс SimpleQueueTest.
*/
	private SimpleQueue<Float> sq; /**Ссылка на объект SimpleQueue.*/
/**
* Метод setUp() создает новый объект SimpleQueue<Float>.
* И добавляет туда объекты Float.
*/
	@Before
	public void setUp() {
		this.sq = new SimpleQueue<Float>();
		sq.push(1.0F);
		sq.push(2.0F);
		sq.push(3.0F);
		sq.push(4.0F);
		sq.push(5.0F);
		sq.push(6.0F);
		sq.push(7.0F);
	}
/**
* Метод poll() извлекает элементы в том же порядке, в котором они были введены в него.
*/
	@Test
	public void whenElementFirstEnteredTheQueueThenOutOfTheQueueIsAlsoTheFirst() {
		assertThat(sq.poll(), is(1.0F));
		assertThat(sq.poll(), is(2.0F));
		assertThat(sq.poll(), is(3.0F));
		assertThat(sq.poll(), is(4.0F));
		assertThat(sq.poll(), is(5.0F));
		assertThat(sq.poll(), is(6.0F));
		assertThat(sq.poll(), is(7.0F));
	}
/**
* Добавляет те же самые элементы в обратном порядке и извлекает их.
*/
	@Test
	public void theSameElementInReverseOrder() {
		sq.push(7.0F);
		sq.push(6.0F);
		sq.push(5.0F);
		sq.push(4.0F);
		sq.push(3.0F);
		sq.push(2.0F);
		sq.push(1.0F);
		assertThat(sq.poll(), is(1.0F));
		assertThat(sq.poll(), is(2.0F));
		assertThat(sq.poll(), is(3.0F));
		assertThat(sq.poll(), is(4.0F));
		assertThat(sq.poll(), is(5.0F));
		assertThat(sq.poll(), is(6.0F));
		assertThat(sq.poll(), is(7.0F));
	}
}