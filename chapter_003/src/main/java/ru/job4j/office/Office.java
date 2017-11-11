package ru.job4j.office;

/**
* Класс Office. Справочник подразделений.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 10.11.2017
* @version
*/

public class Office {
/**
* Класс Office.
*/
/**
* Метод sortAscending. Сортировка кодов подразделений в порядке возрастания.
* @param codes Строковый массив с кодами подразделений.
* @return Отсортированный массив codes.
*/
	public String[] sortAscending(String[] codes) {
		int num = 0;
		String tmp;
		String[] copy = codes;
		for (int i = copy.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				num = copy[j].compareTo(copy[j + 1]);
				if (num > 0) {
					tmp = copy[j];
					copy[j] = copy[j + 1];
					copy[j + 1] = tmp;
				}
			}
		}
		return copy;
	}
/**
* Метод sortDescrease. Сортировка кодов подразделений в порядке убывания.
* @param codes Строковый массив с кодами подразделений.
* @return Отсортированный массив codes.
*/
	public String[] sortDescrease(String[] codes) {
		String[] copy = codes;
		String tmp;
		int index1 = 0; // Переменные используются сначала для хранения колества разделителей "\\" в строке,
		int index2 = 0; // а потом для обозначения верхней границы при извлечении куска из строки.
		int count = 0;
		int num1 = 0; // Переменные для обозначения нижней границы
		int num2 = 0; // при извлечении куска из строки.
		String[] str1; // Массив для хранения частей строки №1
		String[] str2; // Массив для хранения частей строки №2
		for (int i = copy.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				// Проверка на отсутствие пустых значений null.
				if (copy[j] == null || copy[j + 1] == null) {
					continue;
				}
				// Получение количества разделителей "\\" в строке 1 - copy[j]
				count = 0;
				index1 = 0;
				while (copy[j].indexOf("\\", count) >= 0) {
					index1++;
					count = copy[j].indexOf("\\", count) + 1;
				}
				// Получение количества разделителей "\\" в строке 2 - copy[j + 1]
				count = 0;
				index2 = 0;
				while (copy[j + 1].indexOf("\\", count) >= 0) {
					index2++;
					count = copy[j + 1].indexOf("\\", count) + 1;
				}
				// Создание массива str1, и разбивка строки copy[j] на части по разделителю "\\"
				// с последующей их запиью в str1
				if (index1 != 0) {
					num1 = 0;
					str1 = new String[index1 + 1];
					index1 = copy[j].indexOf("\\");
					for (int k = 0; k < str1.length; k++) {
						if (index1 >= 0) {
							str1[k] = copy[j].substring(num1, index1);
							num1 = index1 + 1;
							index1 = copy[j].indexOf("\\", num1);
						} else {
							str1[k] = copy[j].substring(num1, copy[j].length());
						}
					}
				} else {
					str1 = new String[1];
					str1[0] = copy[j];
				}
				// Создание массива str2, и разбивка строки copy[j + 1] на части по разделителю "\\"
				// с последующей их запиью в str2
				if (index2 != 0) {
					num2 = 0;
					str2 = new String[index2 + 1];
					index2 = copy[j + 1].indexOf("\\");
					for (int k = 0; k < str2.length; k++) {
						if (index2 >= 0) {
							str2[k] = copy[j + 1].substring(num2, index2);
							num2 = index2 + 1;
							index2 = copy[j + 1].indexOf("\\", num2);
						} else {
							str2[k] = copy[j + 1].substring(num2, copy[j + 1].length());
						}
					}
				} else {
					str2 = new String[1];
					str2[0] = copy[j + 1];
				}
				// Поэлементное сравнение массивов str1 и str2.
				// Если строка copy[j] по длине короче, copy[j + 1].
				if (copy[j].length() < copy[j + 1].length()) {
					for (int k = 0; k < str1.length; k++) {
						// Если хотя бы один элемент str1 меньше соответствующего элемента str2,
						// то элементы copy[j] и copy[j + 1] меняются местами.
						if (str1[k].compareTo(str2[k]) < 0) {
							tmp = copy[j];
							copy[j] = copy[j + 1];
							copy[j + 1] = tmp;
							break;
						} else if (str1[k].compareTo(str2[k]) == 0) {
							continue;
						} else {
							break;
						}
					}
				// Поэлементное сравнение массивов str1 и str2.
				// Если строки copy[j] и copy[j + 1] равны по длине.
				} else if (copy[j].length() == copy[j + 1].length()) {
					for (int k = 0; k < str1.length; k++) {
						// Если хотя бы один элемент str1 меньше соответствующего элемента str2,
						// то элементы copy[j] и copy[j + 1] меняются местами.
						if (str1[k].compareTo(str2[k]) < 0) {
							tmp = copy[j];
							copy[j] = copy[j + 1];
							copy[j + 1] = tmp;
							break;
						} else if (str1[k].compareTo(str2[k]) == 0) {
							continue;
						} else {
							break;
						}
					}
				// Поэлементное сравнение массивов str1 и str2.
				// При условии, что строка copy[j] длинее, чем copy[j + 1].
				} else if (copy[j].length() > copy[j + 1].length()) {
					for (int k = 0; k < str2.length; k++) {
						// Если хотя бы один элемент str1 меньше соответствующего элемента str2,
						// то элементы copy[j] и copy[j + 1] меняются местами.
						if (str1[k].compareTo(str2[k]) < 0) {
							tmp = copy[j];
							copy[j] = copy[j + 1];
							copy[j + 1] = tmp;
							break;
						// Если итератор цикла k не последний и элементы str1 и str2 равны
						} else if (k != str2.length - 1 && str1[k].compareTo(str2[k]) == 0) {
							continue;
						// Если итератор цикла k последний и элементы str1 и str2 равны, то
						// то элементы меняются местами.
						} else if (k == str2.length - 1 && str1[k].compareTo(str2[k]) == 0) {
							tmp = copy[j];
							copy[j] = copy[j + 1];
							copy[j + 1] = tmp;
							break;
						} else {
							break;
						}
					}
				}
			}
		}
		return copy;
	}
}