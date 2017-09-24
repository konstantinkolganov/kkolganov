package ru.job4j.paint;

/**
* Класс Triangle реализует интерфейс Shape.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 24.09.2017
* @version 2.0
*/

public class Triangle implements Shape {
/**
* Класс Triangle.
*/
	private StringBuilder builder = new StringBuilder(); /**Объект StringBuilder для формирования треугольника.*/
	private static final int N = 5; /**Высота треугольника.*/
/**
* Метод pic() для сложения прямоугольного треугольника в виде строки.
* @return Треугольник.
*/
	public String pic() {
		int whiteSpace = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j < whiteSpace) {
					builder.append("*");
				} else {
					builder.append(" ");
				}
			}
			builder.append("\r\n");
			whiteSpace++;
		}
		return builder.toString();
	}
}