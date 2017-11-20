package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс StoreTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 19.11.2017
* @version 2.0
*/

public class StoreTest {
/**
* Класс StoreTest.
*/
/**
* Тест метода add().
*/
	@Test
	public void whenAddNewElementInRoleStoreThenMethodGetOfSimpleArrayReturnThisElement() {
		// Создать новый объект Role
		Role role = new Role("123", "role1");
		// Создать хранилище RoleStore
		RoleStore<Role> store = new RoleStore<>();
		// Добавить в хранилище объект role
		store.add(role);
		// Получить ссылку на контейнер SimpleArray<Role>
		SimpleArray<Role> sarr = store.getSimple();
		// Сравнить результат с ожидаемым значением
		assertThat(sarr.get(0), is(role));
	}
/**
* Тест метода update().
*/
	@Test
	public void whenReplaceAvailableElementAnotherElementWithTheSameIdThenNewTakesPlaceOfOld() {
		// Создать новый объект User
		User user1 = new User("1111", "user1");
		// Создать хранилище UserStore.
		UserStore<User> store = new UserStore<>();
		// Добавить в это хранилище user1
		store.add(user1);
		// Получить контейнер SimpleArray из UserStore.
		SimpleArray<User> sarr = store.getSimple();
		// Получить id объекта user1 через контейнер
		String id = sarr.get(0).getId();
		// Создать новый объект user2 с таким же id, как у user1
		User user2 = new User(id, "NEW USER");
		// Заменить объект user1 на user2
		store.update(user2);
		// Получить имя user2 через контейнер
		String result = sarr.get(0).getName();
		// Получить имя user2 из самого объекта.
		String expected = user2.getName();
		assertThat(result, is(expected));
	}
/**
* Тест метода delete().
*/
	@Test
	public void whenDeleteElementWithIdThenReturnTrue() {
		// Создать объекты user1 и user2
		User user1 = new User("1111", "user1");
		User user2 = new User("2222", "user2");
		// Создать хранилище UserStore и добавить туда объекты
		UserStore<User> store = new UserStore<>();
		store.add(user1);
		store.add(user2);
		// Удалить первый объект. delete() должен вернуть true
		boolean result = store.delete(user1.getId());
		// Получить контейнер SimpleArray.
		SimpleArray<User> sarr = store.getSimple();
		// После удаления user1 его место должен занять user2
		// Получить имя user2 через контейнер SimpleArray
		String strResult = sarr.get(0).getName();
		// Получить имя user2 непосредственно из объекта
		String strExpected = user2.getName();
		// Сравнить результат выполнения метода delete с ожидаемым значением
		assertThat(result, is(true));
		// Сравнить имя первого элемента SimpleArray с ожидаемым
		assertThat(strResult, is(strExpected));
	}
}