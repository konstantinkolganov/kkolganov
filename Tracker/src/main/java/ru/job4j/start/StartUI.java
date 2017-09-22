package ru.job4j.start;

/**
* Класс StartUI - точка входа в программу.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 20.09.2017
* @version 2.0
*/
public class StartUI {
/**
* Класс StartUI.
* В классе реализуется 6 полей-констант, хранящие ключи меню.
* Главный метод main и 6 методов, реализующих функции программы.
*/
	private static final String ADD = "0"; /**Ключ 0-го пункта меню - добавление новой заявки.*/
	private static final String SHOW = "1"; /**Показ всех заявок.*/
	private static final String EDIT = "2"; /**Редактирование заявки.*/
	private static final String DELETE = "3"; /**Удаление заявки.*/
	private static final String FINDBYID = "4"; /**Поиск заявки по номеру Id.*/
	private static final String FINDBYNAME = "5"; /**Показ всех заявок с указанным именем.*/
	private static final String EXIT = "6"; /**Выход из программы.*/
	private Input input;	/**Для хранения ссылки на объект класса Console- или StubInput.*/
	private Tracker tracker;	/**Для хранения ссылки на объект класса Tracker.*/
/**
* Конструктор StartUI.
* @param input Input.
* @param tracker Tracker.
*/
	public StartUI(Tracker tracker, Input input) {
		this.tracker = tracker;
		this.input = input;
	}
/**
* Метод main.
* Точка входа в программу.
* @param args args.
*/
	public static void main(String[] args) {
		// Создаем объект класса ConsoleInput,
		// который будет возвращать введенные пользователем данные
		ConsoleInput consinput = new ConsoleInput();
		// Создаем объект класса Tracker для хранения заявок
		Tracker tracker = new Tracker();
		// Создаем объект класса StartUI
		StartUI start = new StartUI(tracker, consinput);
		// Запуск программы на выполнение
		start.init();
	}
/**
* Метод init(). Каркас программы.
* Реализует диалог с пользователем.
*/
	public void init() {
		String answer = null;	// Переменная для хранения результата ввода из консоли
		boolean check = true;	// Для проверки условия в цикле while
		int def = 0;			// Переменная, используемая в условном операторе if для проверки
								// соответствия значения введенного пользователем ключа заданному диапазану значений.
		System.out.print("\r\nHello, dear User!\r\n");
		System.out.println("Welcome to the application processing program.");
		System.out.println("The following actions are available to you:");
		while (check) {
			if (def == 0) {
				System.out.print("\r\n0. Add new Item\r\n1. Show all items\r\n2. Edit item\r\n3. Delete item\r\n");
				System.out.print("4. Find item by Id\r\n5. Find items by name\r\n6. Exit Program\r\n");
				answer = input.ask("Please, enter the action number: ");
			} else {
				answer = input.ask("\r\nIncorrect data! Enter a number from 0 to 6.\r\nTry again: ");
				def = 0;
			}
			switch (answer) {
				case ADD:
					this.createItem(tracker, input);
					break;
				case SHOW:
					this.showAllItems(tracker);
					break;
				case EDIT:
					this.editItem(tracker, input);
					break;
				case DELETE:
					this.deleteItem(tracker, input);
					break;
				case FINDBYID:
					this.findItemById(tracker, input);
					break;
				case FINDBYNAME:
					this.findItemsByName(tracker, input);
					break;
				case EXIT:
					check = false;
					break;
				default:
					def = 1;
					break;
			}
		}
	}
/**
* Метод void createItem.
* Создание новой заявки.
* @param tracker Ссылка на объект класса Tracker.
* @param input Ссылка на интерфейс Input.
*/
	public void createItem(Tracker tracker, Input input) {
		String name = input.ask("Please, enter the name of Item: ");
		String descrip = input.ask("OK! Now, enter a description: ");
		Item newItem = tracker.add(new Item(name, descrip, 123L));
		System.out.print("\r\nGreat! New item created!\r\n");
		System.out.println("Name: " + newItem.getName());
		System.out.println("Description: " + newItem.getDesc());
		System.out.println("Id: " + newItem.getId());
		System.out.println();
	}
/**
* Метод void showAllItems.
* Вывод на экран всех заявок.
* @param tracker Ссылка на объект класса Tracker.
*/
	public void showAllItems(Tracker tracker) {
		if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
		} else {
			Item[] allReturn = tracker.findAll();
			System.out.print("\r\nList items:\r\n");
			for (int i = 0; i < allReturn.length; i++) {
				System.out.println("Name of item: " + allReturn[i].getName());
				System.out.println("Description: " + allReturn[i].getDesc());
				System.out.println("Create: " + allReturn[i].getCreate());
				System.out.println("Id: " + allReturn[i].getId());
				System.out.println();
			}
		}
	}
/**
* Метод void editItem.
* Удаление заявки.
* @param tracker Ссылка на объект класса Tracker.
* @param input Ссылка на интерфейс input.
*/
	public void editItem(Tracker tracker, Input input) {
		if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
		} else {
			String id = null;
			id = input.ask("Please, enter the Id number: ");
			if (tracker.findById(id) == null) {
				do {
					id = input.ask("\r\nOooopps!\r\nSuch an Item does not exist.\r\nTry once more: ");
				} while (tracker.findById(id) == null);
			}
			Item item = tracker.findById(id);
			System.out.print("\r\nOK!\r\n");
			System.out.println("Name: " + item.getName());
			System.out.println("Description: " + item.getDesc());
			System.out.println("Id: " + item.getId());
			System.out.println();
			String newName = input.ask("Please, enter the new name: ");
			System.out.println(newName);
			String newDescrip = input.ask("Good! Please, enter the new description: ");
			System.out.println(newDescrip);
			item = new Item(newName, newDescrip, 123L);
			item.setId(id);
			tracker.update(item);
			System.out.println("\r\nGreat! Item modified!\r\n");
			System.out.println("Name: " + item.getName());
			System.out.println("Description: " + item.getDesc());
			System.out.println("Id: " + item.getId());
			System.out.println();
		}
	}
/**
* Метод void DeleteItem.
* Удаление заявки.
* @param tracker Ссылка на объект класса Tracker.
* @param input Ссылка на интерфейс Input.
*/
	public void deleteItem(Tracker tracker, Input input) {
		if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
		} else {
			String id = null;
			id = input.ask("\r\nPlease, enter the Id number: ");
			if (tracker.findById(id) == null) {
				do {
					id = input.ask("\r\nOooopps!\r\nSuch an Item does not exist.\r\nTry once more: ");
				} while (tracker.findById(id) == null);
			}
			Item item = tracker.findById(id);
			System.out.print("\r\nGood!\r\n");
			System.out.println("Name: " + item.getName());
			System.out.println("Description: " + item.getDesc());
			System.out.println("Create: " + item.getCreate());
			System.out.println("Id: " + item.getId());
			tracker.delete(item);
			System.out.print("\r\nSuccessfully deleted!\r\n");
		}
	}
/**
* Метод void findItemById.
* Поиск и отображение заявки по номеру Id.
* @param tracker Ссылка на объект класса Tracker.
* @param input Ссылка на интерфейс Input.
*/
	public void findItemById(Tracker tracker, Input input) {
		if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
		} else {
			String id = null;
			id = input.ask("Please, enter the Id number: ");
			if (tracker.findById(id) == null) {
				do {
					id = input.ask("\r\nOooopps!\r\nSuch an Item does not exist.\r\nTry once more: ");
				} while (tracker.findById(id) == null);
			}
			Item item = tracker.findById(id);
			System.out.println("Good! Item Found!");
			System.out.println("Name: " + item.getName());
			System.out.println("Description: " + item.getDesc());
			System.out.println("Create: " + item.getCreate());
			System.out.println("Id: " + item.getId());
		}
	}
/**
* Метод void findItemsByName.
* Поиск и отображение заявок по имени.
* @param tracker Ссылка на объект класса Tracker.
* @param input Ссылка на интерфейс Input.
*/
	public void findItemsByName(Tracker tracker, Input input) {
		if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
		} else {
			String name = input.ask("Please, enter the name Items: ");
			Item[] arrName = tracker.findByName(name);
			while (arrName == null) {
				name = input.ask("\r\nSORRY!\r\nItems with this name do not exist.\r\nPlease, enter the Name again or \"esc\" for escape: ");
				arrName = tracker.findByName(name);
			}
			System.out.println();
			for (int i = 0; i < arrName.length; i++) {
				System.out.println("Name: " + arrName[i].getName());
				System.out.println("Description: " + arrName[i].getDesc());
				System.out.println("Create: " + arrName[i].getCreate());
				System.out.println("Id: " + arrName[i].getId());
				System.out.println();
			}
		}
	}
}