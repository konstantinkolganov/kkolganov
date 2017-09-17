package ru.job4j.start;

/**
* Класс Item.
* @author Konstantin Kolganov(kkolganov.92@gmail.com)
* @since 16.09.2017
* @version 1.0
*/
public class Item {
/**
* Класс Item.
*/
	private String name; /** Имя заявки. */
	private String desc; /** Описание. */
	private long create; /** Дата. */
	private String id; /** Идентификационный номер. */
/**
* Конструктор по умолчанию.
*/
	public Item() {
	}
/**
* Конструктор с аргументами.
* @param name Имя заявки.
* @param desc Описание.
* @param create Дата создания.
*/
	public Item(String name, String desc, long create) {
		this.name = name;
		this.desc = desc;
		this.create = create;
	}
/**
* Метод getName.
* @return Имя заявки.
*/
	public String getName() {
		return this.name;
	}
/**
* Метод getDesc.
* @return Описание.
*/
	public String getDesc() {
		return this.desc;
	}
/**
* Метод getCreate.
* @return Дата создания.
*/
	public long getCreate() {
		return this.create;
	}
/**
* Метод setId.
* @param id Номер заявки
*/
	public void setId(String id) {
		this.id = id;
	}
/**
* Метод getId.
* @return id Номер заявки.
*/
	public String getId() {
		return this.id;
	}
}