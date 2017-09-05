package ru.job4j.array;
/**
* Класс RotateArray поварачивает массив на 90 градусов по часовой стрелке.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 05.09.2017
* @version 1.0
*/
public class RotateArray {
/**
* Class RotateArray.
* Один метод rotate.
*/
/**
* Метод rotate.
* Принимает квадратный массив, поварачивает его по часовой стрелке на 90 градусов.
* В процессе выполнения метода используется дополнительный массив.
* @param array Массив целых чисел.
* @return editedArray Измененный массив.
*/
	public int[][] rotate(int[][] array) {
		// Константа для размера массива
		int size = array.length;
		// Создаем новый массив для хранения перевернутого массива
		int[][] editedArray = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				editedArray[j][size - 1 - i] = array[i][j];
			}
		}
		return editedArray;
	}
}