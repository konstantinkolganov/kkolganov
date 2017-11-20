package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс RectangularArrayIteratorTest. Тест итератора для прямоугольного массива.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 13.11.2017
* @version 2.0
*/

public class RectangularArrayIteratorTest {
/**
* Класс RectangularArrayIteratorTest.
*/
    private Iterator<Integer> it; /**Ссылка на интерфейс итератора.*/
/**
* Создание нового итератора ArrayIterator.
*/
    @Before
    public void setUp() {
        it = new ArrayIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }
/**
* При каждом вызове next() возвращает текущий элемент.
* при вызове hasNext() возвращает true, если еще есть элементы.
*/
    @Test
    public void hasNextNextSequentialInvocation() {
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
        assertThat(it.hasNext(), is(false));
    }
/**
* Тест на последовательный проход по всем элементам массива.
* В конце генерирует исключение NoSuchElementException.
*/
    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }
/**
* Если hasNext() вызывать несколько раз подряд.
* То каждый раз он вернет одно и то же значение true или false.
*/
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }
}