package ru.job4j.collections;

import java.util.*;
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
* Метод main.
* @param args args.
*/
	public static void main(String[] args) {
		// Новый объект Convert
		ConvertList convertList = new ConvertList();
		// Двумерный целочисленный массив и его инициализация
		int[][] array = new int[3][3];
		System.out.println("Elements of Array : ");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = i * j;
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		// Конвертация массива в список List и вывод на экран
		List<Integer> list = convertList.toList(array);
		System.out.println("Size of list : " + list.size());
		System.out.println("Content of list : " + list);
		// Конвертация списка обратно в массив и вывод его на экран
		// Массив из двух строк.
		int[][] array2 = convertList.toArray(list, 2);
		System.out.println("Elements of Array : ");
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j]);
			}
			System.out.println();
		}
		// Создаем список массивов
		List<int[]> listOfIntArray = new ArrayList<int[]>();
		listOfIntArray.add(new int[]{0, 1});
		listOfIntArray.add(new int[]{2, 3, 4});
		listOfIntArray.add(new int[]{5, 6, 7, 8});
		listOfIntArray.add(new int[]{9, 10, 11, 12, 13});
		listOfIntArray.add(new int[]{14, 15, 16, 17, 18, 19, 20});
		// Выводим список на экран
		System.out.println("Create a new List<int[]>");
		System.out.println("Size of listOfIntArray : " + listOfIntArray.size());
		for (int[] num : listOfIntArray) {
			for (int arr : num) {
				System.out.print(arr + " ");
			}
			System.out.println();
		}
		List<Integer> listOfInteger = convertList.convert(listOfIntArray);
		// Выводим список на экран
		System.out.println("Convert List<int[]> to List<Integer>");
		System.out.println("Size of listOfInteger : " + listOfInteger.size());
		for (Integer integ : listOfInteger) {
			System.out.print(integ + " ");
		}
	}
/**
* Метод toList.
* @param array Двумерный массив целых чисел.
* @return Коллекцию ArrayList<Integer>.
*/
	public List<Integer> toList(int[][] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int[] i : array) {
			for (int j : i) {
				list.add(j);
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
					arRows[i][j] = array[index + j].intValue();
				}
				index += colls;
			}
		} else {
			colls += 1;
			arRows = new int[rows][colls];
			for (int i = 0; i < arRows.length; i++) {
				for (int j = 0; j < arRows[i].length; j++) {
					if ((index + j) < array.length) {
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
			for (int arr : interim) {
				result.add(arr);
			}
		}
		return result;
	}
}