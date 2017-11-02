package ru.job4j.collections;

import java.util.*;
/**
* Класс UserConvert. Преобразование списка пользователей List<User> в отображение Map.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.11.2017
* @version 2.0
*/

public class UserConvert {
/**
* Класс UserConvert.
*/
/**
* Метод main.
* @param args args.
*/
	public static void main(String[] args) {
		// Новый объект UserConvert
		UserConvert usconv = new UserConvert();
		// Создать новый список User-ов
		List<User> users = new ArrayList<User>();
		// Заполнить List<User> элементами
		users.add(new User("Konstantin", "Novomoskovsk", 001));
		users.add(new User("Igor", "Moscow", 002));
		users.add(new User("Dmitry", "Sankt-Petersburg", 003));
		users.add(new User("Stanly", "New-York", 004));
		users.add(new User("Barak Obama", "Washington", 005));
		// Преобразовать лист в хэш-отображение
		Map<Integer, User> map = usconv.process(users);
		// Получить множество записей set
		Set<Map.Entry<Integer, User>> set = map.entrySet();
		// Вывести на экран
		for (Map.Entry<Integer, User> me : set) {
			System.out.print("Name of User : " + me.getValue().getName() + ", ");
			System.out.print(String.format("%s%s;", "Number ID : ", me.getKey()));
			System.out.println();
		}
	}
/**
* Метод process.
* Принимает List<User> и конвертирует его в Map с ключом Integer id и соответствующим ему User.
* @param list Список пользователей User.
* @return Отображение HashMap<Integer, User>.
*/
	public HashMap<Integer, User> process(List<User> list) {
		// Создать хэш-отображение
		HashMap<Integer, User> hmap = new HashMap<Integer, User>();
		// Ввести элементы в хэш-отображение
		for (User user : list) {
			hmap.put(user.getId(), user);
		}
		return hmap;
	}
}