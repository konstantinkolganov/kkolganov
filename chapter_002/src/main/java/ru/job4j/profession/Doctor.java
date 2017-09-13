package ru.job4j.profession;

/**
* Класс Doctor совершает действия над объектами класса Patient.
* Наследуется от класса Profession.
*/
public class Doctor extends Profession {
	
	public Doctor(String name, String diplom, String faculty, String work) {
		this.name = name;
		this.diplom = diplom;
		this.faculty = faculty;
		this.work = work;
	}
/**
* Метод Survey - осмотр пациента.
*/
	public Operation survey(Patient patient) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("Доктор ");
		builder.append(this.name);
		builder.append(" осматривает ");
		builder.append(patient.age);
		if (patient.gender == "мужской") {
			builder.append("-летнего");
			builder.append(" пациента по имени ");
		} else {
			builder.append("-летнюю");
			builder.append(" пациентку по имени ");
		}
		builder.append(patient.name);
		oper.nameOperation = builder.toString();
		return oper;
	}
/**
* Метод diagnostics - доктор ставит диагноз пациенту.
*/
	public Operation diagnostics(Patient patient) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("Доктор ");
		builder.append(this.name);
		builder.append(" ставит дигноз ");
		builder.append(patient.age);
		if (patient.gender == "мужской") {
			builder.append("-летнему");
			builder.append(" пациенту по имени ");
		} else {
			builder.append("-летней");
			builder.append(" пациентке по имени ");
		}
		builder.append(patient.name);
		oper.nameOperation = builder.toString();
		return oper;
	}
/**
* Метод recipe - доктор выписывает рецепт.
*/
	public Operation recipe(Patient patient) {
		Operation oper = new Operation();
		StringBuilder builder = new StringBuilder();
		builder.append("Доктор ");
		builder.append(this.name);
		builder.append(" выписывает рецепт ");
		builder.append(patient.age);
		if (patient.gender == "мужской") {
			builder.append("-летнему");
			builder.append(" пациенту по имени ");
		} else {
			builder.append("-летней");
			builder.append(" пациентке по имени ");
		}
		builder.append(patient.name);
		oper.nameOperation = builder.toString();
		return oper;
	}
}