package ru.job4j.calculator;

/**
* Класс Calculator реализует медоты арифметических операций.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 23.08.2017
* @version 1.0
*/

public class Calculator {
/**
* Методы сложения, вычитания, умножения и деления.
* И getResult, возвращающий результаты действия.
*/

private double result;
/**
* Сложение двух аргументов.
* @param first first.
* @param second second.
*/
    public void add(double first, double second) {
	this.result = first + second;
    }
/**
* Вычитание.
* @param first first.
* @param second second.
*/
    public void subtract(double first, double second) {
	this.result = first - second;
    }
/**
* Деление.
* @param first first.
* @param second second.
*/
    public void div(double first, double second) {
	this.result = first / second;
    }
/**
* Умножение.
* @param first first.
* @param second second.
*/
    public void multiple(double first, double second) {
	this.result = first * second;
    }
/**
* Возврат результата.
* @return result.
*/
    public double getResult() {
	return this.result;
    }
}