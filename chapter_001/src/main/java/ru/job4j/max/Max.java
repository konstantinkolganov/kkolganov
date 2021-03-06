package ru.job4j.max;

/**
* Класс Max выявляет наибольшее из представленных чисел.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 27.08.2017
* @version 1.0
*/
public class Max {
/**
* Класс Max для определения наибольшего числа из заданных.
*/
	private int result;
/**
* Метод принимает два значения и возврвщает наибольшее.
* @param first Первое значение.
* @param second Второе значение.
* @return Наибольшее из двух.
*/
	public int max(int first, int second) {
		this.result = first > second ? first : second;
		return this.result;
	}
/**
* Метод принимает три значения.
* И при помощи предыдущего метода выявляет наибольшее.
* @param first Первое значение.
* @param second Второе значение.
* @param third Третье значение.
* @return Наибольшее из трех.
*/
	public int max(int first, int second, int third) {
		int tmp = this.max(first, second); // tmp - для хранения промежуточного значения
		this.result = this.max(tmp, third);
		return this.result;
	}
}