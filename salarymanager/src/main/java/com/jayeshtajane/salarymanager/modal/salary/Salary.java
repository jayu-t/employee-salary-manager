package com.jayeshtajane.salarymanager.modal.salary;

public class Salary {
	
	public void pay(int empId, double payableAmount) {
		System.out.println("CALL : pay("+ empId + "," + payableAmount +")");
		
		
		
		System.out.println("INFO : "+ payableAmount +"Salary paid to " + empId);
	}
	public void payExtra(int empId, double payableAmount) {
		System.out.println("CALL : payExtra("+ empId + "," + payableAmount +")");
		System.out.println("INFO : " + payableAmount + "give Extra to " + empId);
	}
}
