package ru.job4j.start;

/**
* Класс StartUI - точка входа в программу.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 20.09.2017
* @version 2.0
*/
public class StartUI {
/**
* Класс StartUI.
* В классе реализуется метод main и метод init, реализующих функции программы.
*/
	private Input input;	/**Для хранения ссылки на объект класса Console- или StubInput.*/
	private Tracker tracker;	/**Для хранения ссылки на объект класса Tracker.*/
/**
* Конструктор StartUI.
* @param input Input.
* @param tracker Tracker.
*/
	public StartUI(Tracker tracker, Input input) {
		this.tracker = tracker;
		this.input = input;
	}
/**
* Метод main.
* Точка входа в программу.
* @param args args.
*/
	public static void main(String[] args) {
		// Создаем объект класса Tracker для хранения заявок
		Tracker tracker = new Tracker();
		// Создаем объект класса ValidateInput,
		// который будет возвращать ввод пользователя
		Input input = new ValidateInput();
		// Создаем объект класса StartUI и передаем объекты tracker и input
		StartUI start = new StartUI(tracker, input);
		// Запуск программы на выполнение
		start.init();
	}
/**
* Метод init(). Каркас программы.
* Реализует диалог с пользователем.
* @throws MenuOutException Неверный выбор меню.
*/
	public void init() {
		MenuTracker menu = new MenuTracker(this.tracker, this.input);
		menu.fillAction();
		do {
			menu.show();
			menu.select(this.input.ask("Please, enter the key from 0 to 5: ", menu.getAcrange()));
		} while (!"7".equals(this.input.ask("Exit? Enter \"7\": ")));
	}
}