package ru.job4j.generic;

/**
* Интерфейс SimpleFunction.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 15.11.2017
* @version 2.0
* @param <SimpleArray> Generic.
* @param <T> Generic.
*/

public interface SimpleFunction<SimpleArray, T> {
/**
* Интерфейс SimpleFunction.
*/
/**
* Метод actCont.
* @param sarr Контейнер SimpleArray.
* @param struc Элемент User или Role.
* @return T Элемент.
*/
	T actCont(SimpleArray sarr, T struc);
}