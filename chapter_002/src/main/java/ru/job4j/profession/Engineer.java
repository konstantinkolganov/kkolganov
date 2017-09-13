package ru.job4j.profession;

/**
* Класс Engineer совершает действия над объектами класса Project.
* Наследуется от класса Profession.
*/
public class Engineer extends Professions {
	
	public Engineer(String name, String diplom, String faculty, String work) {
		this.name = name;
		this.diplom = diplom;
		this.faculty = faculty;
		this.work = work;
	}
/**
* Метод calculateProject - Инженер рассчитывает проект.
*/
	public Operation calculateProject(Project project) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("Инженер ");
		builder.append(this.name);
		builder.append(" по специальности \"");
		builder.append(this.faculty);
		builder.append("\" делает рассчеты в проекте \"");
		builder.append(project.nameProject);
		builder.append("\"\r\n");
		oper.nameOperation = builder.toString();
		return oper;
	}
/**
* Метод paperwork - Инженер оформляет документацию.
*/
	public Operation paperwork(Project project) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("После окончания рассчетов ");
		builder.append(this.name);
		builder.append(" подготавливает документы для сдачи проекта организации \"");
		builder.append(project.organization);
		builder.append("\"\r\n");
		oper.nameOperation = builder.toString();
		return oper;
	}
/**
* Метод matching - Передает проект заказчику.
*/
	public Operation matching(Project project) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("После того, как проект \"");
		builder.append(project.name);
		builder.append("\" будет окончательно готов, ");
		builder.append(this.name);
		builder.append(" позвонит представителю организации ");
		builder.append(project.clientName);
		builder.append(" для согласования проекта.\r\n");
		oper.nameOperation = builder.toString();
		return oper;
	}
}