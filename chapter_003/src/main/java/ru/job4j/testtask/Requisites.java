package ru.job4j.testtask;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

/**
* Класс Requisites.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 08.11.2017
* @version 2.0
*/

public class Requisites {
/**
* Класс Requisites.
*/
	private final Random rn = new Random(); /**Рандом.*/
	private Map<String, String> map = new HashMap<String, String>(); /**Список реквизитов.*/
/**
* Конструктор класса.
*/
	public Requisites() {
		this.map.put(Constants.NAMEOFOFFICESTR, Constants.NAMEOFOFFICE);
		this.map.put(Constants.KSSTR, Constants.KS);
		this.map.put(Constants.BIKSTR, Constants.BIK);
		this.map.put(Constants.INNSTR, Constants.INN);
		this.map.put(Constants.BANKACCOUNTSTR, String.format("%d", this.rn.nextLong()));
	}
/**
* Метод getBankAccount. Возвращает значение пары.
* @param Значение.
* @return Номер расчетного счета клиента.
*/
	public String getBankAccount() {
		String result = this.map.get(Constants.BANKACCOUNTSTR);
		return result;
	}
/**
* Метод toString.
* @return Строка "key : value;".
*/
	@Override
	public String toString() {
		String str1 = String.format("%s - %s;", Constants.NAMEOFOFFICESTR, this.map.get(Constants.NAMEOFOFFICESTR));
		String str2 = String.format("%s - %s;", Constants.KSSTR, this.map.get(Constants.KSSTR));
		String str3 = String.format("%s - %s;", Constants.BIKSTR, this.map.get(Constants.BIKSTR));
		String str4 = String.format("%s - %s;", Constants.INNSTR, this.map.get(Constants.INNSTR));
		String str5 = String.format("%s - %s;", Constants.BANKACCOUNTSTR, this.map.get(Constants.BANKACCOUNTSTR));
		String result = String.format("\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n.", str1, str2, str3, str4, str5);
		return result;
	}
}