package ru.job4j.start;

/**
* Класс StubValidateInput наследует StubInput.
* Проверяет корректность ввода пользователя.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 29.09.2017
* @version 2.0
*/

public class StubValidateInput extends StubInput {
/**
* Класс StubValidateInput.
*/
/**
* Конструктор класса.
* Принимает массив и передает его родительскому StubInput.
* @param answers Ссылка на массив.
*/
	public StubValidateInput(String[] answers) {
		super(answers);
	}
/**
* Метод ask.
* @param question Вопрос пользователю.
* @param range Диапазон ключей.
* @return Ключ меню.
*/
	public int ask(String question, int[] range) {
		int value = -1;
		boolean valid = true;
		while (valid) {
			try {
				value = super.ask(question, range);
				valid = false;
			} catch (MenuOutException moe) {
				System.out.println(moe);
			} catch (NumberFormatException nfe) {
				System.out.println("Incorrect format. Try again.");
			}
		}
		return value;
	}
}