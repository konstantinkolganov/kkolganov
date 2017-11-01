package ru.job4j.collections;

import java.util.*;
/**
* Класс Perfomance замеряет время вставки в коллекцию и время удаления случайных строк.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 01.11.2017
* @version 2.0
*/

public class Perfomance {
/**
* Класс Perfomance.
*/
	public static final Random RN = new Random(); /** Random. */
/**
* Метод main.
* @param args args.
*/
	public static void main(String[] args) {
		// Новый объект Perfomance
		Perfomance perf = new Perfomance();
		// Тест коллекции ArrayList
		Collection<String> collectArray = new ArrayList<String>();
		System.out.println("ArrayList :");
		System.out.println("Time of add : " + perf.add(collectArray, 10000));
		System.out.println("Time of delete : " + perf.delete(collectArray, 10000));
		System.out.println();
		// Тест коллекции LinkedList
		Collection<String> collectLink = new LinkedList<String>();
		System.out.println("LinkedList :");
		System.out.println("Time of add : " + perf.add(collectLink, 10000));
		System.out.println("Time of delete : " + perf.delete(collectLink, 10000));
		System.out.println();
		// Тест коллекции TreeSet
		Collection<String> collectSet = new TreeSet<String>();
		System.out.println("TreeSet :");
		System.out.println("Time of add : " + perf.add(collectSet, 10000));
		System.out.println("Time of delete : " + perf.delete(collectSet, 10000));
		System.out.println();
	}
/**
* Метод add. Добавление элементов в коллекцию.
* @param collection Коллекция, куда будут добавляться элементы.
* @param amount Количество элементов.
* @return Время выполнения операции.
*/
	public long add(Collection<String> collection, int amount) {
		// Начало отсчета
		long start = System.nanoTime();
		for (int i = 0; i < amount; i++) {
			collection.add(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
		}
		// Конец отсчета
		long finish = System.nanoTime();
		// Время выполнения
		long result = finish - start;
		return result;
	}
/**
* Метод delete. Удаление элементов из коллекции.
* @param collection Коллекция, куда будут добавляться элементы.
* @param amount Количество элементов для удаления.
* @return Время выполнения операции.
*/
	public long delete(Collection<String> collection, int amount) {
		// Массив для хранения элементов, подлежащих удалению
		String[] array = new String[amount];
		array = collection.toArray(array);
		// Начало отсчета
		long start = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			collection.remove(array[i]);
		}
		// Конец отсчета
		long finish = System.nanoTime();
		// Время выполнения
		long result = finish - start;
		return result;
	}
}