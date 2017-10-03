package ru.job4j.start;

/**
* Класс MenuTracker реализует диалог с пользователем, выполняет действия над заявками.
* @author Konsatntin Kolganov (kkolganov.92@gmail.com)
* @since 25.09.2017
* @version 2.0
*/

public class MenuTracker {
/**
* Класс MenuTracker.
*/
	private Tracker tracker; /**Для хранения ссылки на объект класса Tracker.*/
	private Input input;	/**Для хранения ссылки на объект класса Console- или StubInput.*/
	private ActionTracker actrack = new ActionTracker(); /**Объект ActionTracker.*/
	private int[] acrange = new int[]{0, 1, 2, 3, 4, 5}; /**Массив ключей доступа к разделам меню.*/
/**
* Конструктор MenuTracker.
* @param tracker Tracker.
* @param input Input.
*/
	public MenuTracker(Tracker tracker, Input input) {
		this.tracker = tracker;
		this.input = input;
	}
/**
* Метод getAcrange.
* Возвращает массив с ключами.
* @return Массив с ключами.
*/
	public int[] getAcrange() {
		return this.acrange;
	}
/**
* Метод fillAction().
* Заполнение массива операциями меню.
*/
	public void fillAction() {
		this.actrack.fActions();
	}
/**
* Метод select.
* Выполнение действия.
* @param key Уникальный ключ меню.
*/
	public void select(int key) {
		for (UserAction action : this.actrack.getActions()) {
			if (action != null && (key == action.key())) {
				action.execute(this.tracker, this.input);
			}
		}
	}
/**
* Метод show.
* Отображение меню на экране.
*/
	public void show() {
		System.out.println();
		for (UserAction action : this.actrack.getActions()) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
}