package ru.job4j.testtask;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
* Класс Bank.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 07.11.2017
* @version 2.0
*/

public class Bank {
/**
* Класс Bank.
*/
	private Map<User, List<Account>> map = new HashMap<User, List<Account>>(); /**Коллекция пользователей.
															У каждого пользователя может быть список банковских счетов.*/
/**
* Метод addUser. Добавляет нового пользователя.
* @param user Пользователь.
*/
	public void addUser(User user) {
		if (user != null) {
			List<Account> list = new ArrayList<Account>();
			this.map.put(user, list);
		}
	}
/**
* Метод deleteUser. Удаляет пользователя.
* @param user Пользователь.
*/
	public void deleteUser(User user) {
		if (this.map.get(user) != null) {
			this.map.remove(user);
		}
	}
/**
* Метод addAccountToUser. Добавляет пользователю один новый счет.
* @param user Пользователь.
* @param account Счет.
*/
	public void addAccountToUser(User user, Account account) {
		if (user != null && account != null && this.map.get(user) != null) {
			List<Account> list = this.map.get(user);
			list.add(account);
		}
	}
/**
* Метод deleteAccountFromUser. Удаляет один пользовательский счет.
* @param user Пользователь.
* @param account Счет.
*/
	public void deleteAccountFromUser(User user, Account account) {
		if (user != null && account != null && this.map.get(user) != null) {
			List<Account> list = this.map.get(user);
			list.remove(account);
		}
	}
/**
* Метод getUserAccount. Возвращает список счетов пользователя.
* @param user Пользователь.
* @return Список счетов.
*/
	public List<Account> getUserAccount(User user) {
		List<Account> list = null;
		if (user != null) {
			list = this.map.get(user);
		}
		return list;
	}
/**
* Метод transferMoney. Перевод денег с одного счета на другой.
* @param srcUser Первый пользователь, отправитель денег.
* @param srcAccount Счет первого пользователя.
* @param dstUser Второй пользователь, получатель денег.
* @param dstAccount Счет второго пользователя.
* @param amount Количество денег для перевода.
* @return Если деньги переведены, то true, а иначе - false.
*/
	public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
		boolean transfer = false;
		List<Account> list1;
		List<Account> list2;
		Account account1;
		Account account2;
		if (srcUser != null && dstUser != null && srcAccount != null && dstAccount != null && amount > 0) {
			if (this.map.containsKey(srcUser) && this.map.containsKey(dstUser)) {
				list1 = this.map.get(srcUser);
				list2 = this.map.get(dstUser);
				int indexSrc = 0;
				int indexDst = 0;
				if (list1 != null && list2 != null) {
					indexSrc = list1.indexOf(srcAccount);
					indexDst = list2.indexOf(dstAccount);
				}
				if (indexSrc >= 0 && indexDst >= 0) {
					account1 = list1.get(indexSrc);
					account2 = list2.get(indexDst);
					if (account1.getValue() >= amount) {
						account1.setValue(account1.getValue() - amount);
						account2.setValue(account2.getValue() + amount);
						transfer = true;
					}
				}
			}
		}
		return transfer;
	}
/**
* Метод mapReturn. Возвращает коллекцию map.
* @return this.map.
*/
	public Map<User, List<Account>> mapReturn() {
		return this.map;
	}
}