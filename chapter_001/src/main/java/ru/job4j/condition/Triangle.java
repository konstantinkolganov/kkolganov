package ru.job4j.condition;

/**
* Класс Triangle вычисляет площадь треугольника, образованного точками a, b и c.
* Программа учитывает условия невозможности построить треугольник по этим точкам.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 27.08.2017
* @version 1.0
*/

public class Triangle {
/**
* Класс Треугольник.
*/
	private Point a, b, c;
/**
* Comment.
* @param a Ссылка на объект точки a.
* @param b Ссылка на объект точки b.
* @param c Ссылка на объект точки c.
*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
/**
* Метод должен вычислять расстояния между точками left и right.
* Для вычисления расстояния использовать формулу
* Math.scr((xright - xleft)^2 + (yright - yleft)^2)
* @param left Точка слева.
* @param right Точка справа.
* @return Расстояние между точками left И right.
*/
	public double distance(Point left, Point right) {
		return Math.sqrt(Math.pow((right.getX() - left.getX()), 2) + Math.pow((right.getY() - left.getY()), 2));
	}

/**
* Метод вычисления периметра по длинам сторон.
* Формула
* (ab + bc + ca)/2
*
* @param ab Расстояние между точками a и b.
* @param bc Расстояние между точками b и c.
* @param ac Расстояние между точками a и c.
* @return Периметр треугольника.
*/
	public double period(double ab, double bc, double ac) {
		return (ab + bc + ac) / 2;
	}

/**
* Метод должен вычислить площадь треугольника.
* Формула.
*
* Math.scr(p * (p - ab) * (p - bc) * (p - ac))
*
* @return Вернуть площадь, если треугольник существует, или -1.
*/
	public double area() {
		double rsl = -1;
		double ab = this.distance(this.a, this.b);
		double bc = this.distance(this.b, this.c);
		double ac = this.distance(this.a, this.c);
		double p = this.period(ab, bc, ac);
		if (this.exist(ab, bc, ac)) {
			rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
		}
		return rsl;
	}
/**
* Метод проверяет, можно ли построить треугольник с такими длинами сторон.
* Длина каждой стороны должна быть больше нуля. Т.е точки не должны совпадать.
*
* @param ab Длина стороны ab.
* @param bc Длина стороны bc.
* @param ca Длина стороны ca.
* @return False, если длина хотя бы одной стороны равна нулю.
*/
    public boolean exist(double ab, double bc, double ca) {
		return (ab > 0) && (bc > 0) && (ca > 0) ? true : false;
	}
}