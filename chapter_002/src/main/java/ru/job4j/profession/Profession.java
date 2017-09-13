package ru.job4j.profession;

/**
* Базовый класс Profession.
* От него унаследуются классы Doctor, Engineer и Teacher.
*/
public class Professison {
	
	public String name; // Имя специалиста
	public String diplom; // Название учреждения где он получил диплом
	public String faculty; // Специализация
	public String work; // Место работы
	
	public Profession(String name, String diplom, String faculty, String work) {
		this.name = name;
		this.diplom = diplom;
		this.faculty = faculty;
		this.work = work;
	}
	
	public String getName() {
		return this.name;
	}
	public String getDiplom() {
		return this.diplom;
	}
	public String getFaculty() {
		return this.faculty;
	}
	public String getWork() {
		return this.work;
	}
}