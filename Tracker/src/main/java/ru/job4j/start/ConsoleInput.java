package ru.job4j.start;

import java.util.Scanner;
/**
* Класс ConsoleInput реализует интерфейс Input.
* Оперирует вводными данными из консоли.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 20.09.2017
* @version 2.0
*/
public class ConsoleInput implements Input {
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