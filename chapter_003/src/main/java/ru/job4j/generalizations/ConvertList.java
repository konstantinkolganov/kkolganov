package ru.job4j.generalizations;

import java.util.List;
import java.util.ArrayList;
/**
* Класс Convert. Конвертация двумерного массива в ArrayList и наборот.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.11.2017
* @version 2.0
*/

public class ConvertList {
/**
* Класс Convert.
*/
/**
* Метод toList.
* @param array Двумерный массив целых чисел.
* @return Коллекцию ArrayList<Integer>.
*/
	public List<Integer> toList(int[][] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int[] i : array) {
			if (i != null) {
				for (int j : i) {
					list.add(j);
				}
			}
		}
		return list;
	}
/**
* Метод toArray.
* @param list Коллекция List.
* @param rows Количество строк двумерного массива.
* @return Двумерный массив, состоящий из элементов List.
*/
	public int[][] toArray(List<Integer> list, int rows) {
		int[][] arRows = null;
		// Получение массива из элементов коллекции
		Integer[] array = list.toArray(new Integer[list.size()]);
		// Число колонок в будущем двумерном массиве
		int colls = array.length / rows;
		int index = 0;
		if (array.length % rows == 0) {
			arRows = new int[rows][colls];
			for (int i = 0; i < arRows.length; i++) {
				for (int j = 0; j < arRows[i].length; j++) {
					if (array[index + j] != null) {
						arRows[i][j] = array[index + j].intValue();
					}
				}
				index += colls;
			}
		} else {
			colls += 1;
			arRows = new int[rows][colls];
			for (int i = 0; i < arRows.length; i++) {
				for (int j = 0; j < arRows[i].length; j++) {
					if (array[index + j] != null && (index + j) < array.length) {
						arRows[i][j] = array[index + j].intValue();
					} else {
						arRows[i][j] = 0;
					}
				}
				index += colls;
			}
		}
		return arRows;
	}
/**
* Метод Convert. Принимает список целочисленных массивов.
* И добавляет все элементы этих массивов в общий список List<Integer>.
* @param list Список массивов int[].
* @return Список значений Integer.
*/
	public List<Integer> convert(List<int[]> list) {
		List<Integer> result = new ArrayList<Integer>();
		for (int[] interim : list) {
			if (interim != null) {
				for (int arr : interim) {
					result.add(arr);
				}
			}
		}
		return result;
	}
}