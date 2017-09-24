package ru.job4j.paint;

/**
* Класс Paint печатает фигуру на консоль.
* Сформированную в классе Triangle или Square.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 24.09.2017
* @version 2.0
*/

public class Paint {
/**
* Класс Paint.
*/
/**
* Метод draw.
* Печатает псевдокартинку на консоль.
* @param shape Ссылка на интерфейс Shape.
*/
	public void draw(Shape shape) {
		System.out.print("\r\n");
		System.out.print(shape.pic());
		System.out.print("\r\n");
	}
}