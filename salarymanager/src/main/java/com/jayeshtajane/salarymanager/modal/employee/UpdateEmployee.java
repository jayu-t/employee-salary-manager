package com.jayeshtajane.salarymanager.modal.employee;

import com.jayeshtajane.salarymanager.employee.Employee;

public class UpdateEmployee {
	private Employee emp = null;
	
	public UpdateEmployee(Employee emp) {
		this.emp = emp;
	}
	
	public void update() {
		System.out.println("INFO : Employee updated"); 
	}
}
