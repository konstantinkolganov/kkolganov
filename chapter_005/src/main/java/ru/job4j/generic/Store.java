package ru.job4j.generic;

/**
* Интерфейс Store.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 14.11.2017
* @version 2.0
* @param <T> Тип User или Role.
*/

public interface Store<T extends Base> {
/**
* Интерфейс Store.
*/
/**
* Метод add(). Добавляет объект.
* @param model Новый объект.
* @return Добавленный объект.
*/
	T add(T model);
/**
* Метод update().
* Заменяет элемент заданным объектом model, у которого такой же id.
* @param model Объект T с идентичным id.
* @return Замененный объект.
*/
	T update(T model);
/**
* Метод delete(). Удаляет элемент с заданным id.
* @param id Номер id элемента.
* @return Логическое true, если элемент удален, а иначе - false.
*/
	boolean delete(String id);
}