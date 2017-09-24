package ru.job4j.paint;

/**
* Класс Square реализует интерфейс Shape.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 24.09.2017
* @version 2.0
*/

public class Square implements Shape {
/**
* Класс Square.
*/
	private StringBuilder builder = new StringBuilder(); /**Объект StringBuilder для формирования строки.*/
	private static final int N = 4; /**Размер квадрата.*/
/**
* Метод pic() для сложения квадрата в виде строки.
* @return Квадрат.
*/
	public String pic() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				builder.append("*");
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}
}