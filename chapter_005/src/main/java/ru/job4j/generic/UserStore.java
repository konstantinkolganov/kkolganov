package ru.job4j.generic;


/**
* Класс UserStore.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 14.11.2017
* @version 2.0
* @param <T> Тип User или Role.
*/

public class UserStore<T extends Base> extends AbstractStore<T> {
/**
* Класс UserStore.
*/
	private SimpleArray<T> userSimple; /**Хранилище SimpleArray.*/
/**
* Конструктор класса.
*/
	public UserStore() {
		this.userSimple = new SimpleArray<T>();
	}
/**
* Метод add(). Добавляет объект.
* @param model Новый объект.
* @return Добавленный объект.
*/
	public T add(T model) {
		return super.actionModel(this.userSimple, model, (sarr, struc) -> {
			return (T) sarr.add(struc);
		});
	}
/**
* Метод update().
* Заменяет элемент массива заданным объектом model, у которого такой же id.
* @param model Объект T с идентичным id.
* @return Замененный объект.
*/
	public T update(T model) {
		return super.actionModel(this.userSimple, model, (sarr, struc) -> {
			return (T) sarr.update(struc);
		});
	}
/**
* Метод delete(). Удаляет элемент с заданным id.
* @param id Номер id элемента.
* @return Логическое true, если элемент удален, а иначе - false.
*/
	public boolean delete(String id) {
		return super.actionDelete(this.userSimple, id, (sarr, model) -> {
			return sarr.delete(id);
		});
	}
/**
* Метод getSimple.
* Возвращает ссылку на контейнер SimpleArray из хранилища UserStore. Метод только для теста.
* @return SimpleArray<T>.
*/
	public SimpleArray<T> getSimple() {
		return this.userSimple;
	}
}