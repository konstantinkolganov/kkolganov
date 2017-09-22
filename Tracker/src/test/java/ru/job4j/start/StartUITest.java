package ru.job4j.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс StartUITest проверяет работоспособность приложения Tracker.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 22.09.2017
* @version 2.0
*/

public class StartUITest {
/**
* Класс StartUITest.
* Содержит 2 тест-метода.
*/
/**
* В методе путем эмуляции добавляем заявку в трекер.
* А затем сравниваем имя созданной заявки с ожидаемым.
*/
	@Test
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
		// Создаем новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Создаем новый объект класса StubInput и вносим последовательность действий
		Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
		// Создаем объект StartUI и вызываем метод init()
		new StartUI(tracker, input).init();
		// Проверяем, что нулевой элемент массива содержит имя, введенное при эмуляции
		assertThat(tracker.findAll()[0].getName(), is("test name"));
	}
/**
* Напрямую добавляем заявку в трекер.
* С помощью виртуального пользователя изменяем имя и описание этой заявки.
* Проверяем, что заявка содержит имя, введенное при эмуляции.
*/
	@Test
	public void whenUpdateThenTrackerHasUpdatedValue() {
		// Создаем новый объект класса Tracker
		Tracker tracker = new Tracker();
		// Добаляем заявку в трекер вручную
		Item item = tracker.add(new Item("Test", "desc", 123L));
		// Задаем последовательность выбора виртуального пользователя
		Input input = new StubInput(new String[]{"2", item.getId(), "testUpdate", "descUpdate", "6"});
		// Создаем StartUI и вызываем метод init()
		new StartUI(tracker, input).init();
		// Проверяем, что нулевой элемент массива содержит имя, введенное при эмуляции
		assertThat(tracker.findById(item.getId()).getName(), is("testUpdate"));
	}
}