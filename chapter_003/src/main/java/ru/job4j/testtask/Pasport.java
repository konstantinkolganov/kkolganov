package ru.job4j.testtask;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
* Класс Pasport.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.11.2017
* @version 2.0
*/

public class Pasport {
/**
* Класс Pasport.
*/
	private Map<String, String> map = new HashMap<String, String>(); /**Отображение map для хранения данных о паспорте.*/
/**
* Метод addHomePage.
* Добаление данных главной страницы пасорта.
* @param name ФИО.
* @param gender Пол.
* @param dateOfBirth Дата рождения.
* @param placeOfBirth Место рождения.
*/
	public void addHomePage(String name, String gender, String dateOfBirth, String placeOfBirth) {
		this.map.put(Constants.NAMEFLP, name);
		this.map.put(Constants.GENDER, gender);
		this.map.put(Constants.DATEOFBIRTH, dateOfBirth);
		this.map.put(Constants.PLACEOFBIRTH, placeOfBirth);
	}
/**
* Метод addRegistration.
* Добаление адреса регистрации.
* @param region Область.
* @param city Город.
* @param street Улица.
* @param home Дом.
* @param appartment Квартира.
*/
	public void addRegistration(String region, String city, String street, String home, String appartment) {
		this.map.put(Constants.REGION, region);
		this.map.put(Constants.CITY, city);
		this.map.put(Constants.STREET, street);
		this.map.put(Constants.HOME, home);
		this.map.put(Constants.APPARTMENT, appartment);
	}
/**
* Метод addPasportInformation.
* Информация о самом паспорте.
* @param series Серия.
* @param number Номер паспорта.
* @param divisionCode КОд подразделения.
* @param dateOfIssue Дата выдачи.
* @param nameOfOrganization Имя организации, которая занимается выдачей паспорта.
*/
	public void addPasportInformation(String series, String number, String divisionCode, String dateOfIssue, String nameOfOrganization) {
		this.map.put(Constants.SERIES, series);
		this.map.put(Constants.NUMBER, number);
		this.map.put(Constants.DIVISIONCODE, divisionCode);
		this.map.put(Constants.DATEOFISSUE, dateOfIssue);
		this.map.put(Constants.NAMEOFORGANIZATION, nameOfOrganization);
	}
/**
* Возврает множество Set<Map.Entry> из элементов map.
* @return Множество Set.
*/
	public Set<Map.Entry<String, String>> getSet() {
		return this.map.entrySet();
	}
/**
* Метод printHomePage.
* Вывод информации с главной страницы паспорта.
* @return Строку.
*/
	public String printHomePage() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");
		builder.append("Pasport Home Page:\r\n");
		builder.append(String.format("%s - %s;", Constants.NAMEFLP, this.map.get(Constants.NAMEFLP)));
		builder.append(String.format("%s - %s;", Constants.GENDER, this.map.get(Constants.GENDER)));
		builder.append(String.format("%s - %s;", Constants.DATEOFBIRTH, this.map.get(Constants.DATEOFBIRTH)));
		builder.append(String.format("%s - %s;", Constants.PLACEOFBIRTH, this.map.get(Constants.PLACEOFBIRTH)));
		builder.append("\r\n");
		return builder.toString();
	}
/**
* Метод printRegistration.
* Вывод серии, номера и т.д.
* @return Строку.
*/
	public String printRegistration() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");
		builder.append("Pasport Registration:\r\n");
		builder.append(String.format("%s - %s;", Constants.REGION, this.map.get(Constants.REGION)));
		builder.append(String.format("%s - %s;", Constants.CITY, this.map.get(Constants.CITY)));
		builder.append(String.format("%s - %s;", Constants.STREET, this.map.get(Constants.STREET)));
		builder.append(String.format("%s - %s;", Constants.HOME, this.map.get(Constants.HOME)));
		builder.append(String.format("%s - %s;", Constants.APPARTMENT, this.map.get(Constants.APPARTMENT)));
		builder.append("\r\n");
		return builder.toString();
	}
/**
* Метод printPasportInformation.
* Вывод серии, номера и т.д.
* @return Строку.
*/
	public String printPasportInformation() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");
		builder.append("Pasport Information:\r\n");
		builder.append(String.format("%s - %s;", Constants.SERIES, this.map.get(Constants.SERIES)));
		builder.append(String.format("%s - %s;", Constants.NUMBER, this.map.get(Constants.NUMBER)));
		builder.append(String.format("%s - %s;", Constants.DIVISIONCODE, this.map.get(Constants.DIVISIONCODE)));
		builder.append(String.format("%s - %s;", Constants.DATEOFISSUE, this.map.get(Constants.DATEOFISSUE)));
		builder.append(String.format("%s - %s;", Constants.NAMEOFORGANIZATION, this.map.get(Constants.NAMEOFORGANIZATION)));
		builder.append("\r\n");
		return builder.toString();
	}
/**
* Метод outOfPasportInformation.
* Вывод всей информации о паспорте.
*/
	public void outOfPasportInformation() {
		String str = "\r\nPASPORT-PASPORT-PASPORT-PASPORT-PASPORT\r\n\r\n";
		String str1 = this.printHomePage();
		String str2 = this.printPasportInformation();
		String str3 = this.printRegistration();
		String result = String.format("%s%s%s%s%s", str, str1, str2, str3, str);
		System.out.print(result);
	}
}