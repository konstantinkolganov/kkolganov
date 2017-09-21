package ru.job4j.start;

import java.util.Scanner;
/**
* Класс ConsoleInput.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 20.09.2017
* @version 2.0
*/
public class ConsoleInput {
/**
* Класс ConsoleInput.
*/
	private Scanner scanner = new Scanner(System.in);
/**
* Метод ask.
* @param question Вопрос пользователю.
* @return Введенные пользователем данные из консоли.
*/
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
}