package ru.job4j.start;

/**
* Класс ActionTracker является оболочкой над массивом операций.
* Каждая из которых соответствует определенному разделу меню.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 02.10.2017
* @version 2.0
*/

public class ActionTracker {
/**
* Класс ActionTracker.
*/
	private UserAction[] actions = new UserAction[6];	/**Массив операций.*/
	private int position = 0; /**Индекс массива операций.*/
/**
* Метод getActions.
* Возвращает массив операций меню.
* @return useraction Массив.
*/
	public UserAction[] getActions() {
		UserAction[] useraction = null;
		if (this.actions != null) {
			useraction = new UserAction[actions.length];
			int index = 0;
			for (UserAction actions : this.actions) {
				if (actions != null) {
					useraction[index++] = actions;
				}
			}
		}
		return useraction;
	}
/**
* Метод fillAction().
* Заполнение массива анонимными классами.
* Которые принимают название и номер операции в качестве параметров.
*/
	public void fActions() {
		this.createItem();
		this.showAllItems();
		this.editItem();
		this.deleteItem();
		this.findItemById();
		this.findItemsByname();
	}
/**
* Метод addAction.
* Присвоение элементу массива определенной операции.
* @param baseaction BaseAction.
*/
	public void addAction(BaseAction baseaction) {
		this.actions[this.position++] = baseaction;
	}
/**
* Метод createItem().
* Создание новой заявки.
*/
	public void createItem() {
		this.addAction(new BaseAction("Create new item", 0) {
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
		});
	}
/**
* Метод showAllItems.
* Показ всех заявок.
*/
	public void showAllItems() {
		this.addAction(new BaseAction("Show all items", 1) {
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
		});
	}
/**
* Метод editItem.
* Редактирование заявки.
*/
	public void editItem() {
		this.addAction(new BaseAction("Edit item", 2) {
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
		});
	}
/**
* Метод DeleteItem.
* Удаление заявки.
*/
	public void deleteItem() {
		this.addAction(new BaseAction("Delete item", 3) {
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
		});
	}
/**
* Метод findItemById.
* Поиск заявки по id.
*/
	public void findItemById() {
		this.addAction(new BaseAction("Find item by id", 4) {
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
		});
	}
/**
* Метод findItemsByname.
* Поиск заявки по имени.
*/
	public void findItemsByname() {
		this.addAction(new BaseAction("Find items by name", 5) {
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
		});
	}
}