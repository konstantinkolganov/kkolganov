package ru.job4j.start;

/**
* Класс MenuTracker реализует диалог с пользователем, выполняет действия над заявками.
* Класс CreateItem реализует интерфейс UserAction, является внешним для класса MenuTracker.
* Класс ShowAllItems реализует интерфейс UserAction, является внутренним нестатическим классом MenuTracker.
* Класс EditItem реализует интерфейс UserAction, является вложенным статическим классом внутри MenuTracker.
* Класс DeleteItem реализует интерфейс UserAction, является вложенным статическим классом внутри MenuTracker.
* Класс FindItemById реализует интерфейс UserAction, является вложенным статическим классом внутри MenuTracker.
* Класс FindItemsByName реализует интерфейс UserAction, является вложенным статическим классом внутри MenuTracker.
* @author Konsatntin Kolganov (kkolganov.92@gmail.com)
* @since 25.09.2017
* @version 2.0
*/
/**
* Класс CreateItem.
* Создание новой заявки.
*/
	class CreateItem implements UserAction {
/**
* Класс CreateItem.
*/
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return "0".
*/
		public String key() {
			return "0";
		}
/**
* Метод execute.
* Выполненяет добавление заявки.
* @param tracker Tracker.
* @param input Input.
*/
		public void execute(Tracker tracker, Input input) {
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
* Метод info.
* Отображение информации.
* @return Add new Item.
*/
		public String info() {
			return String.format("%s. %s", this.key(), "Add new Item");
		}
	}
/**
* Класс MenuTracker.
* Реализует диалог с пользователем, выполняет действия над заявками.
*/
public class MenuTracker {
/**
* Класс MenuTracker.
*/
	private Tracker tracker; /**Для хранения ссылки на объект класса Tracker.*/
	private Input input;	/**Для хранения ссылки на объект класса Console- или StubInput.*/
	private UserAction[] actions = new UserAction[6]; /**Массив действий.*/
/**
* Конструктор MenuTracker.
* @param tracker Tracker.
* @param input Input.
*/
	public MenuTracker(Tracker tracker, Input input) {
		this.tracker = tracker;
		this.input = input;
	}
/**
* Метод fillAction().
* Заполнение массива ссылками на экземпляры классов, описывающих действия.
*/
	public void fillAction() {
		actions[0] = new CreateItem();
		actions[1] = this.new ShowAllItems();
		actions[2] = new MenuTracker.EditItem();
		actions[3] = new MenuTracker.DeleteItem();
		actions[4] = new MenuTracker.FindItemById();
		actions[5] = new MenuTracker.FindItemsByName();
	}
/**
* Метод select.
* Выполнение действия.
* @param key Уникальный ключ меню.
*/
	public void select(String key) {
		for (UserAction action: this.actions) {
			if (action != null && key.equals(action.key())) {
				action.execute(this.tracker, this.input);
				break;
			}
		}
	}
/**
* Метод show.
* Отображение меню на экране.
*/
	public void show() {
		System.out.println();
		for (UserAction action: this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
/**
* Класс ShowAllItems. Принадлежит классу MenuTracker.
* Отображение всех заявок.
*/
	private class ShowAllItems implements UserAction {
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return "1".
*/
		public String key() {
			return "1";
		}
/**
* Метод execute.
* Выполняет отображение всех заявок.
* @param tracker Tracker.
* @param input Input.
*/
		public void execute(Tracker tracker, Input input) {
			if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
			System.out.print("\r\n");
			} else {
				Item[] allReturn = tracker.findAll();
				System.out.print("\r\nList items:\r\n");
				for (Item item: allReturn) {
					System.out.println("Name of item: " + item.getName());
					System.out.println("Description: " + item.getDesc());
					System.out.println("Create: " + item.getCreate());
					System.out.println("Id: " + item.getId());
					System.out.println();
				}
			}
		}
/**
* Метод info.
* Отображение информации.
* @return Show all items.
*/
		public String info() {
			return String.format("%s. %s", this.key(), "Show all items");
		}
}
/**
* Класс EditItem.
* Редактирование заявки.
*/
	private static class EditItem implements UserAction {
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return "2".
*/
		public String key() {
			return "2";
		}
/**
* Метод execute.
* Выполняет редактирование заявки.
* @param tracker Tracker.
* @param input Input.
*/
		public void execute(Tracker tracker, Input input) {
			if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
			System.out.print("\r\n");
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
				System.out.print("\r\n");
				System.out.println("\r\nGreat! Item modified!\r\n");
				System.out.println("Name: " + item.getName());
				System.out.println("Description: " + item.getDesc());
				System.out.println("Id: " + item.getId());
				System.out.println();
			}
		}
/**
* Метод info.
* Отображение информации.
* @return Edit item.
*/
		public String info() {
			return String.format("%s. %s", this.key(), "Edit item");
		}
	}
/**
* Класс DeleteItem.
* Удаление заявки.
*/
	private static class DeleteItem implements UserAction {
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return "3".
*/
		public String key() {
			return "3";
		}
/**
* Метод execute.
* Выполняет удаление заявки.
* @param tracker Tracker.
* @param input Input.
*/
		public void execute(Tracker tracker, Input input) {
			if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
			System.out.print("\r\n");
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
				System.out.print("\r\n");
			}
		}
/**
* Метод info.
* Отображение информации.
* @return Delete item.
*/
		public String info() {
			return String.format("%s. %s", this.key(), "Delete item");
		}
	}
/**
* Класс FindItemById.
* Поиск заявки по номеру id.
*/
	private static class FindItemById implements UserAction {
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return "4".
*/
		public String key() {
			return "4";
		}
/**
* Метод execute.
* Выполняет поиск заявки по id.
* @param tracker Tracker.
* @param input Input.
*/
		public void execute(Tracker tracker, Input input) {
			if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
			System.out.print("\r\n");
			} else {
				String id = null;
				id = input.ask("Please, enter the Id number: ");
				if (tracker.findById(id) == null) {
					do {
						id = input.ask("\r\nOooopps!\r\nSuch an Item does not exist.\r\nTry once more: ");
					} while (tracker.findById(id) == null);
				}
				Item item = tracker.findById(id);
				System.out.print("\r\n");
				System.out.println("Good! Item Found!");
				System.out.println("Name: " + item.getName());
				System.out.println("Description: " + item.getDesc());
				System.out.println("Create: " + item.getCreate());
				System.out.println("Id: " + item.getId());
				System.out.print("\r\n");
			}
		}
/**
* Метод info.
* Отображение информации.
* @return Find item by id.
*/
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by id");
		}
	}
/**
* Класс FindItemsByName.
* Поиск заявкок по имени.
*/
	private static class FindItemsByName implements UserAction {
/**
* Метод key.
* Возвращает уникальный ключ меню.
* @return "5".
*/
		public String key() {
			return "5";
		}
/**
* Метод execute.
* Выполняет поиск заявок по имени.
* @param tracker Tracker.
* @param input Input.
*/
		public void execute(Tracker tracker, Input input) {
			if (tracker.findAll() == null) {
			System.out.print("\r\nYou have not created none Items.\r\n");
			System.out.print("\r\n");
			} else {
				String name = input.ask("Please, enter the name Items: ");
				Item[] arrName = tracker.findByName(name);
				while (arrName == null) {
					name = input.ask("\r\nSORRY!\r\nItems with this name do not exist.\r\nPlease, enter the Name again or \"esc\" for escape: ");
					arrName = tracker.findByName(name);
				}
				System.out.println();
				for (Item item: arrName) {
					System.out.println("Name: " + item.getName());
					System.out.println("Description: " + item.getDesc());
					System.out.println("Create: " + item.getCreate());
					System.out.println("Id: " + item.getId());
					System.out.println();
				}
			}
		}
/**
* Метод info.
* Отображение информации.
* @return Find items by name.
*/
		public String info() {
			return String.format("%s. %s", this.key(), "Find items by name");
		}
	}
}