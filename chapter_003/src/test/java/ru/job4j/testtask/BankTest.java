package ru.job4j.testtask;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс BankTest. Тест методов класса Bank.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 08.11.2017
* @version 2.0
*/

public class BankTest {
/**
* Класс BankTest.
*/
/**
* Тест метода addUser.
*/
	@Test
	public void whenAddUserToMapAndCheckedAvailabilityThenReturnTrue() {
		// Создать объект Bank
		Bank bank = new Bank();
		// Создать объект Pasport и инициализировать его
		Pasport pasport = new Pasport();
		pasport.addHomePage("Kolganov Konstantin Nikolaevich", "Man", "09.11.1992", "Severo-Zadonsk, Tula region");
		pasport.addPasportInformation("7011", "412378", "708-001", "16.09.2009", "Office of Migration Service of city Donskoy");
		pasport.addRegistration("Tula region", "Donskoy", "Lenina", "33", "2");
		// Создать объект User, который включает объект pasport
		User user = new User("Kolganov Konstantin Nikolaevich", pasport);
		// Добавить User в коллекцию пользователей
		bank.addUser(user);
		// Получить коллекцию пользователей
		Map<User, List<Account>> map = bank.mapReturn();
		// Проверить коллекцию map на наличие user
		boolean result = map.containsKey(user);
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(true));
	}
/**
* Тест метода deleteUser.
*/
	@Test
	public void whenDeleteUserAndCheckedAvailabilityUserThenReturnFalse() {
		Bank bank = new Bank();
		// Создать объект Pasport и инициализировать его
		Pasport pasport = new Pasport();
		pasport.addHomePage("Kolganov Konstantin Nikolaevich", "Man", "09.11.1992", "Severo-Zadonsk, Tula region");
		pasport.addPasportInformation("7011", "412378", "708-001", "16.09.2009", "Office of Migration Service of city Donskoy");
		pasport.addRegistration("Tula region", "Donskoy", "Lenina", "33", "2");
		// Создать объект User, который включает объект pasport
		User user = new User("Kolganov Konstantin Nikolaevich", pasport);
		// Добавить User в коллекцию пользователей
		bank.addUser(user);
		// Получить коллекцию пользователей
		Map<User, List<Account>> map = bank.mapReturn();
		// Переменная результат
		boolean result = true;
		// Если объект user существует в коллекции, то он удаляется
		// и осуществляется проверка коллекции на наличие user.
		// Поскольку он будет отсутствовать, то возвратится false.
		if (map.containsKey(user)) {
			map.remove(user);
			result = map.containsKey(user);
		}
		// Сравниваем результат с ожидаемым значением
		assertThat(result, is(false));
	}
/**
* Тест метода addAccountToUser.
*/
	@Test
	public void whenAddAccountWithOneThousandRubThenUserIsVeryHappy() {
		Bank bank = new Bank();
		// Создать объект Pasport и инициализировать его
		Pasport pasport = new Pasport();
		pasport.addHomePage("Kolganov Konstantin Nikolaevich", "Man", "09.11.1992", "Severo-Zadonsk, Tula region");
		pasport.addPasportInformation("7011", "412378", "708-001", "16.09.2009", "Office of Migration Service of city Donskoy");
		pasport.addRegistration("Tula region", "Donskoy", "Lenina", "33", "2");
		// Создать объект User, который включает объект pasport
		User user = new User("Kolganov Konstantin Nikolaevich", pasport);
		// Создать объект Account, и положить туда 1000
		Account account = new Account(1000);
		// Добавить User в коллекцию пользователей
		bank.addUser(user);
		// Добавить счет пользователю
		bank.addAccountToUser(user, account);
		// Получить объект Map
		Map<User, List<Account>> map = bank.mapReturn();
		// Получить счет пользователя user из коллекции пользователей
		Account result = map.get(user).get(0);
		// Сравнить результат с ожидаемым знаечением
		assertThat(result.getValue(), is(1000.0));
	}
/**
* Тест метода deleteAccountFromUser.
*/
	@Test
	public void whenDeleteAccountFromMapThenMethodInexOfReturnNegativeMeaning() {
		Bank bank = new Bank();
		// Создать объект Pasport и инициализировать его
		Pasport pasport = new Pasport();
		pasport.addHomePage("Kolganov Konstantin Nikolaevich", "Man", "09.11.1992", "Severo-Zadonsk, Tula region");
		pasport.addPasportInformation("7011", "412378", "708-001", "16.09.2009", "Office of Migration Service of city Donskoy");
		pasport.addRegistration("Tula region", "Donskoy", "Lenina", "33", "2");
		// Создать объект User, который включает объект pasport
		User user = new User("Kolganov Konstantin Nikolaevich", pasport);
		// Создать несколько объектов счетов
		Account account1 = new Account(1000);
		Account account2 = new Account(2300);
		Account account3 = new Account(4100);
		// Добавить User в коллекцию пользователей
		bank.addUser(user);
		// Добавить счета пользователю
		bank.addAccountToUser(user, account1);
		bank.addAccountToUser(user, account2);
		bank.addAccountToUser(user, account3);
		// Получить объект Map
		Map<User, List<Account>> map = bank.mapReturn();
		// Удалить счет, на котором лежит 1000
		bank.deleteAccountFromUser(user, account1);
		// Получить список всех счетов пользователя User.
		List<Account> list = map.get(user);
		// Метод должен вернуть -1
		int result = list.indexOf(account1);
		// Сравнить результат с ожидаемым значением
		assertThat(result, is(-1));
	}
/**
* Тест метода getUserAccount.
*/
	@Test
	public void whenReturnListAccountFromUserThenItEqualsList() {
		Bank bank = new Bank();
		// Создать объект Pasport и инициализировать его
		Pasport pasport = new Pasport();
		pasport.addHomePage("Kolganov Konstantin Nikolaevich", "Man", "09.11.1992", "Severo-Zadonsk, Tula region");
		pasport.addPasportInformation("7011", "412378", "708-001", "16.09.2009", "Office of Migration Service of city Donskoy");
		pasport.addRegistration("Tula region", "Donskoy", "Lenina", "33", "2");
		// Создать объект User, который включает объект pasport
		User user = new User("Kolganov Konstantin Nikolaevich", pasport);
		// Добавить пользователя user в коллекцию
		bank.addUser(user);
		// Создать несколько счетов для пользователя user.
		Account account1 = new Account(1000);
		Account account2 = new Account(2300);
		Account account3 = new Account(4100);
		// Добавить счета пользователю
		bank.addAccountToUser(user, account1);
		bank.addAccountToUser(user, account2);
		bank.addAccountToUser(user, account3);
		// Добавить счета в список list
		List<Account> list = new ArrayList<Account>();
		list.add(account1);
		list.add(account2);
		list.add(account3);
		// Получить список счетов от пользователя
		List<Account> result = bank.getUserAccount(user);
		// Сравнить результат с ожидаемым значением
		assertThat(result, is(list));
	}
/**
* Тест метода transferMoner.
*/
	@Test
	public void whenTransferOneHundredUser1ToUser2ThenAccount1TwoHundredAndAccount2EigthHundread() {
		Bank bank = new Bank();
		// Создать паспорт для одного пользователя и инициализировать его
		Pasport pasport1 = new Pasport();
		pasport1.addHomePage("Kolganov Konstantin Nikolaevich", "Man", "09.11.1992", "Severo-Zadonsk, Tula region");
		pasport1.addPasportInformation("7011", "412378", "708-001", "16.09.2009", "Office of Migration Service of city Donskoy");
		pasport1.addRegistration("Tula region", "Donskoy", "Lenina", "33", "2");
		// Создать объект User, который включает объект pasport1
		User user1 = new User("Kolganov Konstantin Nikolaevich", pasport1);
		bank.addUser(user1);
		// Создать паспорт для другого пользователя и инициализировать его
		Pasport pasport2 = new Pasport();
		pasport2.addHomePage("Ivanov Igor Sergeevich", "Man", "21.05.1993", "Polyarny, Murmansk region");
		pasport2.addPasportInformation("7014", "423524", "723-104", "23.06.2010", "Office of Migration Service of city Murmansk");
		pasport2.addRegistration("Murmansk region", "Polyarny", "Kosmonavtov", "2", "19");
		// Создать объект User, который включает объект pasport2
		User user2 = new User("Ivanov Igor Sergeevich", pasport2);
		bank.addUser(user2);
		// Добавить счет первому пользователю и положить ему 300 рублей
		Account account1 = new Account(300);
		bank.addAccountToUser(user1, account1);
		// Добавить счет второму пользователю и положить ему 700 рублей
		Account account2 = new Account(700);
		bank.addAccountToUser(user2, account2);
		// Перевести 100 рублей с одного счета на другой
		bank.transferMoney(user1, account1, user2, account2, 100);
		// Если на первом счету 200 рублей, а на втором - 800 рублей, то result = 1
		int result = 0;
		if (account1.getValue() == 200 && account2.getValue() == 800) {
			result = 1;
		}
		// Сравнить резельтат с ожидаемым значением
		assertThat(result, is(1));
	}
}