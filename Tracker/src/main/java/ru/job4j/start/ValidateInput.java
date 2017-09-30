package ru.job4j.start;

/**
* Класс ValidateInput наследует ConsoleInput.
* Проверяет корректность ввода пользователя.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 29.09.2017
* @version 2.0
*/

public class ValidateInput extends ConsoleInput {
/**
* Класс ValidateInput.
*/
/**
* Метод ask.
* @param question Вопрос пользователю.
* @param range Диапазон ключей.
* @return Ключ меню.
*/
	public int ask(String question, int[] range) {
		boolean valid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				valid = false;
			} catch (MenuOutException moe) {
				System.out.println("Invalid input! Enter key from menu.");
			} catch (NumberFormatException nfe) {
				System.out.println("Incorrect format! Try again.");
			}
		} while (valid);
		return value;
	}
}