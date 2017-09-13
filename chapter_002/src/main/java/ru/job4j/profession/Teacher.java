package ru.job4j.profession;

/**
* Класс Teacher совершает действия над объектами класса Student.
* Наследуется от класса Profession.
*/
public class Teacher extends Profession {
	
	public Teacher(String name, String diplom, String faculty, String work) {
		this.name = name;
		this.diplom = diplom;
		this.faculty = faculty;
		this.work = work;
	}
/**
* Метод teach - Учитель объясняет студенту новую тему.
*/
	public Operation teach(Student student) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("Учитель ");
		builder.append(this.name);
		builder.append(" объясняет новую тему студенту ");
		builder.append(student.course);
		builder.append("-го курса по имени");
		builder.append(student.name);
		builder.append(".\r\n");
		oper.nameOperation = builder.toString();
		return oper;
	}
/**
* Метод homework - Дает студенту домашнее задание.
*/
	public Operation homework(Student student) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("Учитель ");
		builder.append(this.name);
		builder.append(" дает студенту ");
		builder.append(student.course);
		builder.append("-го курса по имени ");
		builder.append(student.name);
		builder.append(" новое домашнее задание.\r\n");
		oper.nameOperation = builder.toString();
		return oper;
	}
/**
* Метод rating - Учитель ставит студенту оценку.
*/
	public Operation rating(Student student) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("После проверки домашнего задания студент ");
		builder.append(student.name);
		builder.append(" получает оценку.\r\n");
		oper.nameOperation = builder.toString();
		return oper;
	}
}