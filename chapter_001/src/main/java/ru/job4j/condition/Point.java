package ru.job4j.condition;

/**
* Класс Point описывает точку в системе координат.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 27.08.17
* @version 1.0
*/

public class Point {
/**
* В классе определяются два поля x и y, соответствующие координатам точек.
* Два метода, возвращающих значения x,y. И метод, определяющий принадлежность точки к
* заданной функции по формуле.
*/
	private int x, y;
/**
* Comment.
* @param x Ось абцисс.
* @param y Ось ординат.
*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
/**
* getX возвращает значение по оси x.
* @return x.
*/
	public int getX() {
		return this.x;
	}
/**
* getY возвращает значение по оси y.
* @return y.
*/
	public int getY() {
		return this.y;
	}
/**
* Метод is проверяет принадлежность заданной точки к функции y(x) = a * x + b.
* @param a int.
* @param b int.
* @return True, если условие выполняется.
*/
	public boolean is(int a, int b) {
		return y == a * x + b;
	}
}