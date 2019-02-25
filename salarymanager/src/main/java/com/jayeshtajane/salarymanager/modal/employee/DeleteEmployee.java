package com.jayeshtajane.salarymanager.modal.employee;

import com.jayeshtajane.salarymanager.employee.Employee;

public class DeleteEmployee {
	private int empId;
	
	public DeleteEmployee(int empId) {
		this.empId = empId;
	}
	
	public void delete() {
		System.out.println("INFO :"+ empId +" Employee deleted"); 
	}
}
