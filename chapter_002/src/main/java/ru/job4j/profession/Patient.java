package ru.job4j.profession;

/**
* Класс Patient (пациент) используется классом Doctor.
*/
public class Patient {
	
	public String name; // Имя пациента
	public int age; // Возраст пациента
	public String gender; // Пол пациента
	public String diagnosis; // Текущий диагноз
	
	public Patient(String name, int age, String gender, String diagnosis) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.diagnosis = diagnosis;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public String getDiagnosis() {
		return this.diagnosis;
	}
}