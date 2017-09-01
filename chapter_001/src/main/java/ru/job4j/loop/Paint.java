package ru.job4j.loop;

/**
* Класс Paint отрисовывает пирамиду из символов "^" и пробелов.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 01.09.2017
* @version 1.0
*/

public class Paint {
/**
* Класс Paint.
* Одно поле completedString типа String и метод piramid.
*/
	private String completedString; // поле класса для хранения готовой строки
/**
* Метод piramid.
* Формула определения ширины пирамиды по высоте.
* a = a1 + ((h - h1) * 2), где a1, h1- ширина и высота для пирамиды
* высотой = 1 и шириной = 1.
* @param h Высота пирамиды.
* @return Готовая строка символов.
*/
	public String piramid(int h) {
		// ширина пирамиды
		int a = 1 + ((h - 1) * 2);
		// переменная для учета количества пробелов в начале и конце строки
		int y = a - h;
		// Создаем объект класса StringBuilder
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < a; j++) {
				if ((j >= (a - (a - y))) && (j < (a - y))) {
					builder.append("^");
				} else {
					builder.append(" ");
				}
			}
			builder.append("\r\n");
			y--;
		}
		this.completedString = builder.toString();
		return this.completedString;
	}
}