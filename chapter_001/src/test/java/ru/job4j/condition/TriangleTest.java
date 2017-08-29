package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* Класс TriangleTest тестирует методы класса Triangle.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 27.08.2017
* @version 1.0
*/
public class TriangleTest {
/**
* Метод вычисляет площадь треугольника с заданными точками.
* И сравнивает результат с ожидаемым значением.
*/
	@Test
	public void whenAreaSetThreePointsThenTriangleArea() {
		// Создаем три объекта класса Point
		Point a = new Point(0, 0);
		Point b = new Point(0, 2);
		Point c = new Point(2, 0);
		// Создаем объект треугольник и передаем в него ссылки на объекты точек
		Triangle triangle = new Triangle(a, b, c);
		// Вычисляем площадь
		double result = triangle.area();
		// Ожидаемый результат
		double expected = 2D;
		// Проверяем результат и ожидаемое значение
		assertThat(result, closeTo(expected, 0.1));
	}
}