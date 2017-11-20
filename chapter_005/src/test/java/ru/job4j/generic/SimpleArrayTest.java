package ru.job4j.generic;

import java.lang.IndexOutOfBoundsException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
* Класс SimpleArrayTest.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 19.11.2017
* @version 2.0
*/

public class SimpleArrayTest {
/**
* Класс SimpleArrayTest.
*/
	private SimpleArray<User> sarr; /**Ссылка на контейнер SimpleArray.*/
/**
* Метод setUp() создает новый контейнер SimpleArray<User>.
*/
	@Before
	public void setUp() {
		this.sarr = new SimpleArray<User>();
	}
/**
* Метод get(index) возвращает элемент по указанному индексу.
* Если индекс выходит за границы массива, то генерируется исключение IndexOutOfBoundsException.
*/
	@Test(expected = IndexOutOfBoundsException.class)
	public void whenCallMethodGetWithIndexThenReturnElementCorrespondingToTheIndex() {
		// Новые объекты User.
		User user1 = new User("120", "user1");
		User user2 = new User("121", "user2");
		User user3 = new User("122", "user3");
		User user4 = new User("123", "user4");
		User user5 = new User("124", "user5");
		User user6 = new User("125", "user6");
		User user7 = new User("126", "user7");
		User user8 = new User("127", "user8");
		User user9 = new User("128", "user9");
		User user10 = new User("129", "user10");
		User user11 = new User("130", "user11");
		User user12 = new User("131", "user12");
		// Добавить их в контейнер sarr.
		this.sarr.add(user1);
		this.sarr.add(user2);
		this.sarr.add(user3);
		this.sarr.add(user4);
		this.sarr.add(user5);
		this.sarr.add(user6);
		this.sarr.add(user7);
		this.sarr.add(user8);
		this.sarr.add(user9);
		this.sarr.add(user10);
		this.sarr.add(user11);
		this.sarr.add(user12);
		// Выполнить проверку
		assertThat(this.sarr.get(0), is(user1));
		assertThat(this.sarr.get(1), is(user2));
		assertThat(this.sarr.get(2), is(user3));
		assertThat(this.sarr.get(3), is(user4));
		assertThat(this.sarr.get(4), is(user5));
		assertThat(this.sarr.get(5), is(user6));
		assertThat(this.sarr.get(6), is(user7));
		assertThat(this.sarr.get(7), is(user8));
		assertThat(this.sarr.get(8), is(user9));
		assertThat(this.sarr.get(9), is(user10));
		assertThat(this.sarr.get(10), is(user11));
		assertThat(this.sarr.get(11), is(user12));
		this.sarr.get(12);
	}
/**
* Тест метода update().
*/
	@Test
	public void whenCallMethodUpdateThenElementToArrayIsReplacedAnotherElementWithTheSameId() {
		SimpleArray<User> arUser = new SimpleArray<>();
		User user1 = new User("123", "user1");
		User user2 = new User("124", "user2");
		User user3 = new User("125", "user3");
		arUser.add(user1);
		arUser.add(user2);
		arUser.add(user3);
		// Создать новый объект User, у которого id такой же, как у user1
		User newUser = new User(user1.getId(), "User is updated!");
		// Заменить user1 на новый user, у которого имя "User is updated!"
		User userReturn = arUser.update(newUser);
		// Сравнить результат с ожидаемым значением
		assertThat(arUser.get(0).getName(), is("User is updated!"));
		// Метод update() должен вернуть ссылку на прежний объект - это user1.
		assertThat(userReturn, is(user1));
	}
/**
* Тест метода delete().
*/
	@Test
	public void whenDeleteElementWithIdThenReturnTrue() {
		SimpleArray<User> arUser = new SimpleArray<>();
		User user1 = new User("123", "user1");
		User user2 = new User("124", "user2");
		User user3 = new User("125", "user3");
		arUser.add(user1);
		arUser.add(user2);
		arUser.add(user3);
		// Удалить 2 - й элемент по id(объект user2). Метод должен вернуть true
		boolean result = arUser.delete(arUser.get(1).getId());
		// Сравнить результат с ожидаемым значением
		assertThat(result, is(true));
		// При удалении одного элемента все следующие за ним элементы
		// сдвигаются на одну позицию назад. User3 был на 2-й позиции,
		// после удаления user2 должен сдвинуться на 1-ю.
		assertThat(arUser.get(1), is(user3));
	}
}