package ru.job4j.start;

import java.util.Set;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
* Класс Tracker.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 16.09.2017
* @version 2.0
*/
public class Tracker {
/**
* Класс Tracker.
*/
	private Map<String, Item> items = new HashMap<String, Item>(); /** Список заявок. */
	public static final Random RN = new Random(); /** Random. */
/**
* Метод add. Добавление заявки.
* @param item Ссылку на объект заявки класса Item.
* @return Ссылку на тот же объект с инициализированным полем id.
*/
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.put(item.getId(), item);
		return item;
	}
/**
* Метод update. Редактирование заявки.
* @param item Ссылку на заявку.
*/
	public void update(Item item) {
		this.items.put(item.getId(), item);
	}
/**
* Метод findById. Поиск заявки по id.
* @param id Номер заявки в строковой форме.
* @return Item Заявку с подходящим номером id.
*/
	public Item findById(String id) {
		return this.items.get(id);
	}
/**
* Метод findByName. Получение списка по имени.
* @param key Имя заявки.
* @return Список List заявок.
*/
	public List<Item> findByName(String key) {
		List<Item> list = new ArrayList<Item>();
		if (!this.items.isEmpty()) {
			Set<Map.Entry<String, Item>> set = this.items.entrySet();
			for (Map.Entry<String, Item> setItems : set) {
				if (setItems != null && setItems.getValue().getName().equals(key)) {
					list.add(setItems.getValue());
				}
			}
		}
		return list;
	}
/**
* Метод findAll. Получение списка всех заявок.
* @return Список заявок без null.
*/
	public List<Item> findAll() {
		List<Item> list = new ArrayList<Item>();
		if (!this.items.isEmpty()) {
			Set<Map.Entry<String, Item>> set = this.items.entrySet();
			for (Map.Entry<String, Item> setItems : set) {
				if (setItems != null) {
					list.add(setItems.getValue());
				}
			}
		}
		return list;
	}
/**
* Метод delete. Удаление заявки.
* @param item Ссылку на объект заявки.
*/
	public void delete(Item item) {
		this.items.remove(item.getId());
	}
/**
* Метод generateId. Генератор номера id.
* @return Номер заявки в строковой форме.
*/
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
}