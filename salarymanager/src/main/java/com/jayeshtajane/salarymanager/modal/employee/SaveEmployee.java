package com.jayeshtajane.salarymanager.modal.employee;

import com.jayeshtajane.salarymanager.employee.Employee;

public class SaveEmployee {
	private Employee emp = null;
	
	public SaveEmployee(Employee emp) {
		super();
		this.emp = emp;
	}
	
	public void save() {
		System.out.println("INFO : Employee data saved.");
	}
}
