package ru.job4j.start;

import java.util.Random;
import java.util.Arrays;

/**
* Класс Tracker.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 16.09.2017
* @version 1.0
*/
public class Tracker {
/**
* Класс Tracker.
*/
	private Item[] items = new Item[100]; /** Список заявок. */
	private int position; /** Счетчик массива items[]. */
	public static final Random RN = new Random(); /** Random. */
/**
* Метод add. Добавление заявки.
* @param item Ссылку на объект заявки класса Item.
* @return Ссылку на тот же объект с инициализированным полем id.
*/
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return item;
	}
/**
* Метод update. Редактирование заявки.
* @param item Ссылку на заявку.
*/
	public void update(Item item) {
		for (int index = 0; index != this.position; index++) {
			if (item != null && this.items[index].getId().equals(item.getId())) {
				this.items[index] = item;
			}
		}
	}
/**
* Метод findById. Поиск заявки по id.
* @param id Номер заявки в строковой форме.
* @return Item Заявку с подходящим номером id.
*/
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
			result = item;
			break;
			}
		}
		return result;
	}
/**
* Метод findByName. Получение списка по имени.
* @param key Имя заявки.
* @return Массив заявок с совпадающими именами.
*/
	public Item[] findByName(String key) {
		Item[] result = new Item[this.position];
		int index = 0;
		for (Item item : items) {
			if (item != null && item.getName().equals(key)) {
				result[index++] = item;
			}
		}
		return Arrays.copyOf(result, (this.position - (this.position - index)));
	}
/**
* Метод findAll. Получение списка всех заявок.
* @return Копию массива this.items без null-элементов.
*/
	public Item[] findAll() {
		Item[] result = new Item[this.items.length];
		int index = 0;
		for (Item item : items) {
			if (item != null) {
				result[index++] = item;
			}
		}
		return result;
	}
/**
* Метод delete. Удаление заявки.
* @param item Ссылку на объект заявки.
*/
	public void delete(Item item) {
		for (int index = 0; index < this.position; index++) {
			if (item != null && items[index].getId().equals(item.getId())) {
				items[index] = null;
				break;
			}
		}
	}
/**
* Метод generateId. Генератор номера id.
* @return Номер заявки в строковой форме.
*/
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
}