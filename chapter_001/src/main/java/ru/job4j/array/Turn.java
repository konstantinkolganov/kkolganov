package ru.job4j.array;

/**
* Класс Turn меняет порядок элементов массива на обратный.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.09.2017
* @version 1.0
*/
public class Turn {
/**
* Класс Turn.
*/
/**
* Метод back принимает массив целочисленных значений.
* Проверяет его на четность/нечетность числа элементов и, в соответствии
* с результатом, меняет порядок элементов на обратный по соответствующей инструкции.
* @param array Ссылка на массив целых чисел.
* @return Ссылка на измененный массив.
*/
	public int[] back(int[] array) {
		// Если массив имеет четное число элементов
		if (array.length % 2 == 0) {
			for (int i = 0; i < (array.length / 2); i++) {
				int tmp = 0; // переменная для хранения промежуточного значения
				tmp = array[i];
				array[i] = array[array.length - 1 - i];
				array[array.length - 1 - i] = tmp;
			}
		// Если массив нечетный
		} else {
			for (int i = 0; i < ((array.length - 1) / 2); i++) {
				 int tmp = 0;
				 tmp = array[i];
				 array[i] = array[array.length - 1 - i];
				 array[array.length - 1 - i] = tmp;
			}
		}
		return array;
	}
}