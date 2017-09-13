package ru.job4j.profession;

/**
* Класс Project используется классом Engineer.
*/
public class Project {
	
	public String nameProject; // Название проекта
	public int deadline; // Срок выполнения проекта (в днях)
	public String clientName; // Имя представителя организации
	public String organization; // Название организации
	
	public Project(String nameProject, int deadline, String clientName, String organization) {
		this.nameProject = nameProject;
		this.deadline = deadline;
		this.clientName = clientName;
		this.organization = organization;
	}
	
	public String getName() {
		return this.nameProject;
	}
	
	public int getDeadline() {
		return this.deadline;
	}
	
	public String getClientName() {
		return this.clientName;
	}
	
	public String getOrganization() {
		return this.organization;
	}
}