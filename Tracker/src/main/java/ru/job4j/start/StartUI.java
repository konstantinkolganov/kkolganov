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
		// Создаем объект класса ConsoleInput,
		// который будет возвращать введенные пользователем данные
		Input input = new ConsoleInput();
		// Создаем объект класса Tracker для хранения заявок
		Tracker tracker = new Tracker();
		// Создаем объект класса StartUI
		StartUI start = new StartUI(tracker, input);
		// Запуск программы на выполнение
		start.init();
	}
/**
* Метод init(). Каркас программы.
* Реализует диалог с пользователем.
*/
	public void init() {
		String answer;
		MenuTracker menu = new MenuTracker(this.tracker, this.input);
		menu.fillAction();
		do {
			menu.show();
			answer = this.input.ask("Please, enter the number from 0 to 5 or \"7\" for Exit: ");
			menu.select(answer);
		} while (!"7".equals(answer));
	}
}