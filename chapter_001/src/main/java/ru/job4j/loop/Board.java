package ru.job4j.loop;
/**
* Класс Board служит для отрисовки шахматной доски.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 31.08.2017
* @version 1.0
*/
public class Board {
/**
* Класс Board.
* Одно поле completedString и метод paint.
*/
	private String completedString; // для хранения готовой строки
/**
* Метод paint.
* На основе заданных параметров складывает шахматную доску из "x" и " "(пробела).
* @param width Ширина доски.
* @param weight Длина доски.
* @return Цепочка символов.
*/
	public String paint(int width, int weight) {
		// Создаем новый объект класса StringBuilder
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < weight; i++) {
			for (int j = 0; j < width; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						builder.append("x"); // метод .append добавляет символ в буфер
					} else {
						builder.append(" ");
					}
				} else {
					if (j % 2 == 0) {
						builder.append(" ");
					} else {
						builder.append("x");
					}
				}
			}
			builder.append("\r\n");
		}
		this.completedString = builder.toString();
		return this.completedString;
	}
}