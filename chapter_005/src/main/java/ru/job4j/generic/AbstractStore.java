package ru.job4j.generic;

import java.util.function.BiPredicate;

/**
* Класс AbstractStore.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 14.11.2017
* @version 2.0
* @param <T> Тип User или Role.
*/

public abstract class AbstractStore<T extends Base> implements Store<T> {
/**
* Класс RoleStore.
*/
/**
* Метод actionDelete.
* @param sarr SimpleArray<T>.
* @param str Номер id.
* @param bipred BiPredicate<T>.
* @return true or false.
*/
	public boolean actionDelete(SimpleArray sarr, String str, BiPredicate<SimpleArray, String> bipred) {
		return bipred.test(sarr, str);
	}
/**
* Метод actionModel.
* @param sarr SimpleArray<T>.
* @param model T.
* @param sfunc SimpleFunction<T>.
* @return T Элемент.
*/
	public T actionModel(SimpleArray sarr, T model, SimpleFunction<SimpleArray, T> sfunc) {
		return sfunc.actCont(sarr, model);
	}
/**
* Метод add(). Добавляет объект.
* @param model Новый объект.
* @return Добавленный объект.
*/
	public abstract T add(T model);
/**
* Метод update().
* Заменяет элемент массива заданным объектом model, у которого такой же id.
* @param model Объект T с идентичным id.
* @return Замененный объект.
*/
	public abstract T update(T model);
/**
* Метод delete(). Удаляет элемент с заданным id.
* @param id Номер id элемента.
* @return Логическое true, если элемент удален, а иначе - false.
*/
	public abstract boolean delete(String id);
/**
* Метод getSimple.
* Возвращает контейнер SimpleArray из хранилища Store. Метод только для теста.
* @return SimpleArray<T>.
*/
	public abstract SimpleArray<T> getSimple();
}