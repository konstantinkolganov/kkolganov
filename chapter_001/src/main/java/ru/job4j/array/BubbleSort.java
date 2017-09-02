package ru.job4j.array;
/**
* Класс BubbleSort сортирует массив целых значений.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.09.2017
* @version 1.0
*/
public class BubbleSort {
/**
* Класс BubbleSort.
*/
/**
* Метод sort.
* Принимает массив целых чисел, содержащий значения в произвольном порядке.
* Метод упорядочивает значения в порядке возрастания.
* @param array Сссылка на целочисленный массив.
* @return Ссылка на сортированный массив.
*/
	public int[] sort(int[] array) {
		for (int j = array.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (array[i] > array[i + 1]) {
					int tmp = 0;
					tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
				}
			}
		}
		return array;
	}
}