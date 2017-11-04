/**
* Файл package-info.java описывает содержимое пакета ru.job4j.board;
* Класс Start точка входа в программу.
* Класс CoordinatesFormatException выбрасывает исключение, если адрес ячейки шахматной доски указан неверно.
* Класс FigureNotFoundException позволяет генерировать исключение если в ячейке не найдена фигура.
* Класс ImpossibleMoveException позволяет генерировать исключение, если фигура не может быть перемещена в заданную ячейку.
* Класс OccupiedWayException позволяет генерировать исключение, если на пути стоит другая фигура.
* Класс Coordinate определяет положение поля(ячейки) в плоскости шахматной доски.
* Абстрактный класс Figure определяет фигуры шахматной доски.
* Класс Cell определяет ячейку шахматной доски.
* Класс Board формирует шахматную доску, создает набор фигур.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.10.2017
* @version 2.0
*/

package ru.job4j.board;