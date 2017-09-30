package ru.job4j.start;

/**
* Класс StubInput реализует интерфейс Input.
* Служит эмулятором ввода данных пользователя.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 22.09.2017
* @version 2.0
*/
public class StubInput implements Input {
/**
* Класс StubInput.
*/
	private String[] answers;	/**Массив, хранящий наборы команд управления программой.*/
	private int position = 0;	/**Счетчик массива.*/
/**
* Конструктор класса.
* Принимает ссылку на массив и присваивает ее полю answers.
* @param answers Ссылка на массив.
*/
	public StubInput(String[] answers) {
		this.answers = answers;
	}
/**
* Метод ask.
* @param question Строку.
* @return Выбор элемента меню.
*/
	public String ask(String question) {
		return this.answers[this.position++];
	}
/**
* Метод ask.
* @param question Вопрос пользователю.
* @param range Диапазон ключей.
* @return Ключ меню.
*/
	public int ask(String question, int[] range) {
		int key = -1;
		int num = Integer.parseInt(this.ask(question));
		boolean exist = true;
		for (int value : range) {
			if (num == value) {
				exist = false;
				key = num;
				break;
			}
		}
		if (exist) {
			throw new MenuOutException("Invalid input! Enter key from menu.");
		}
		return key;
	}
}