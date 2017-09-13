package ru.job4j.profession;

/**
* Класс Student используется классом Teacher.
*/
public class Student {
	
	public String name; // Имя студента
	public int course; // Номер курса
	public String faculty; // Факультет
	public String institution; // Название университета
	
	public Student(String name, int course, String faculty, String institution) {
		this.name = name;
		this.course = course;
		this.faculty = faculty;
		this.institution = institution;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public String getFaculty() {
		return this.faculty;
	}
	
	public String getInstitution() {
		return this.institution;
	}
}