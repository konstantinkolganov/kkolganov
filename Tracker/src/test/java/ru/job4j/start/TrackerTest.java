package ru.job4j.start;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс TrackerTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 16.09.2017
* @version 1.0
*/
public class TrackerTest {
/**
* Class TrackerTest.
* Реализует тесты на 6 методов класса Tracker.
*/
/**
* Тест метода public Item add(Item item).
* Добавление заявок.
*/
	@Test
	public void whenUpdateNameThenReturnNewName() {
		// Новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Новый объект-заявка
		Item item = new Item("test1", "TestDescription", 123L);
		// Вносим нашу заявку в массив заявок
		tracker.add(item);
		// Сравниваем результат с ожидаемым значением
		assertThat(tracker.findAll().get(0), is(item));
	}
/**
* Тест метода public void update(Item item).
* Редактирование заявки.
*/
	@Test
	public void whenFindIdThenReplaceNote() {
		// Новый объкект класса Tracker
		Tracker tracker = new Tracker();
		// Создаем заявку
		Item previous = new Item("Test1", "TestDescription", 123L);
		tracker.add(previous);
		// Создаем новую заявку с таким же id, как у предыдущей
		Item next = new Item("Test2", "TestDescription", 1234L);
		next.setId(previous.getId());
		// Заменяем в массиве первую заявку второй
		tracker.update(next);
		// Сравниваем результат с ожидаемым значением
		assertThat(tracker.findById(previous.getId()).getName(), is("Test2"));
	}
/**
* Тест метода public Item findById(String id).
* Поиск заявки по id.
*/
	@Test
	public void whenFindbyIdThenReturnNote() {
		// Новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Новый объект-заявка
		Item item = new Item("Test1", "TestDescription", 123L);
		tracker.add(item);
		// Сравниваем результат с ожидаемым значением
		assertThat(tracker.findById(item.getId()), is(item));
	}
/**
* Тест метода public Item[] findByName(String key).
* Получение списка по имени и возврат его в виде массива.
*/
	@Test
	public void whenFindByNameThenReturnArrayWithTheSameNames() {
		// Новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Создаем объект-заявку и присваиваем ее элементам массива items[] три раза
		Item item = new Item("Test1", "TestDescription", 123L);
		tracker.add(item);
		tracker.add(item);
		tracker.add(item);
		// Создаем список List<Item> и инициализируем его теми же значениями
		List<Item> result = new ArrayList<Item>();
		result.add(item);
		result.add(item);
		result.add(item);
		// Сравниваем результат с ожидаемым значением
		assertThat(tracker.findByName("Test1"), is(result));
	}
/**
* Тест метода public List<Item> findAll().
* Получение списка всех заявок.
* Множество TreeSet для сортировки элементов.
*/
	@Test
	public void whenSortOutArrayThenReturnCopyArrayLessNull() {
		// Новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Создаем две заявки и заносим их в список заявок
		Item item1 = new Item("Test1", "Test1Description", 123L);
		Item item2 = new Item("Test2", "Test2Description", 1234L);
		Item item3 = new Item("Test3", "Test3Description", 12345L);
		Item item4 = new Item("Test4", "Test4Description", 12346L);
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		tracker.add(item4);
		// Удалим третью заявку
		tracker.delete(item3);
		// Создаем множество TreeSet<Item> из элементов листа в Tracker-е
		Set<Item> result = new TreeSet<Item>(tracker.findAll());
		// Создаем множество TreeSet<Item> с такими же элементами, как в листе Tracker
		Set<Item> expected = new TreeSet<Item>();
		expected.add(item1);
		expected.add(item2);
		expected.add(item4);
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
/**
* Тест метода public void delete(Item item).
* Удаление заявки.
* Множество TreeSet для сортировки элементов.
*/
	@Test
	public void whenFindByIdThenAssignNull() {
		// Новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Создаем три заявки и заносим их в список заявок
		Item item1 = new Item("Test1", "Test1Description", 123L);
		Item item2 = new Item("Test2", "Test2Description", 1234L);
		Item item3 = new Item("Test3", "Test3Description", 12345L);
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		// Удаляем вторую заявку
		tracker.delete(item2);
		// Создаем множество TreeSet<Item> из элементов листа в Tracker-е
		Set<Item> result = new TreeSet<Item>(tracker.findAll());
		// Создаем множество TreeSet<Item> с такими же элементами, как в листе Tracker
		Set<Item> expected = new TreeSet<Item>();
		expected.add(item1);
		expected.add(item3);
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(expected));
	}
}